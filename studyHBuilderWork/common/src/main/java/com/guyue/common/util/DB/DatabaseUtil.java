package com.guyue.common.util.DB;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;

import com.guyue.common.Enum.DBTypeEnum;
import com.guyue.common.util.GuyueLoggerFactory;
import com.guyue.common.util.GuyueStringBuffer;
import com.guyue.common.util.StringUtil;
import com.guyue.common.util.bean.GuYueBeanUtil;
import com.guyue.common.util.classload.ClassLoadUtil;
import com.guyue.common.vo.DBColumn;
import com.guyue.common.vo.DBConnecttion;
import com.guyue.common.vo.DBTable;
@SuppressWarnings("unchecked")
public class DatabaseUtil<T> {
	private static Logger logger = GuyueLoggerFactory.getLogger(DatabaseUtil.class);
	private static Connection connect;
	public static Connection createAndReturenConnect(DBConnecttion connection){
		if(StringUtil.isNotEmpty(connection.getJdbcJarPath())){
//			根据jar包路径加载驱动类
			ClassLoadUtil.loadClassByJarPath(connection.getJdbcJarPath());
		}
		try{
		 Class.forName(connection.getJdbcDiverClass());
		 Driver driver = DriverManager.getDriver(connection.getJdbcUrl());
		 Properties connectionProperties = new Properties();
		 connectionProperties.put("user", connection.getJdbcUserName());
		 connectionProperties.put("password", connection.getJdbcPassword());
		 connect = driver.connect(connection.getJdbcUrl(), connectionProperties);
		 }catch(Exception e){
			 logger.error("创建连接失败",e);
		 }
		return connect;
	}
	public static Connection getConnection(){
		if(connect!=null){
			return connect;
		}
		logger.error("获取连接失败,请执行createAndReturenConnect获取连接");
		return connect;
	}
	public static void clearConnection(){
		connect=null;
	}
	/**
	 * 执行语句，返回Map对象
	  * @Title: queryForMap 
	  * @Description: 
	  * @param sql
	  * @param params
	  * @return
	 */
	public static Map<String,Object> queryForMap(String sql,List<Object>... params){
		Map<String,Object> resultMap = new HashMap<String, Object>();
		List<Map<String, Object>> queryForList = queryForListMap(sql, params);
		resultMap = queryForList.get(0);
		return resultMap;
	}
	/**
	 * 执行语句，返回Map对象
	  * @Title: queryForMap 
	  * @Description: 
	  * @param sql
	  * @param params
	  * @return
	 */
	@SuppressWarnings("rawtypes")
	public static<T> T queryForBean(String sql,Class className,List<Object>... params){
		List<T> queryForList = queryForListBean(sql, className,params);
		T bean = queryForList.get(0);
		return bean;
	}
	/**
	 * 执行sql，返回List对象
	  * @Title: queryForList 
	  * @Description: 
	  * @param sql
	  * @param params
	  * @return
	 */
	public static boolean excuteSqlNoDataReturn(String sql,List<Object>... params){
		logger.debug("执行SQL语句开始：{}，参数内容是{}", sql,Arrays.toString(params));
		boolean result=false;
		PreparedStatement prepareStatement=null;
		try{
			prepareStatement = connect.prepareStatement(sql);
			if(params.length>0){
				for(int i=0;i<params[0].size();i++){
					prepareStatement.setObject(i, params[0].get(i));
				}
			}
			result = prepareStatement.execute();
		}catch(Exception e){
			logger.error("执行sql语句失败", e);
		}finally{
			try{
			prepareStatement.close();
			connect.close();
			}catch(Exception e){
				logger.error("执行sql发生异常", e);
			}
		}
		return result;
	}
	/**
	 * 执行sql，返回List对象
	  * @Title: queryForList 
	  * @Description: 
	  * @param sql
	  * @param params
	  * @return
	 */
	@SuppressWarnings({"rawtypes"})
	public static<T> List<T> queryForListBean(String sql,Class className,List<Object>... params){
		logger.debug("执行SQL语句开始：{}，参数内容是{}", sql,Arrays.toString(params));
		List<T> resultList = new ArrayList<T>();
		ResultSet rst=null;
		PreparedStatement prepareStatement=null;
		try{
			prepareStatement = connect.prepareStatement(sql);
			if(params.length>0){
				for(int i=0;i<params[0].size();i++){
					prepareStatement.setObject(i, params[0].get(i));
				}
			}
			boolean result = prepareStatement.execute();
			if(result){
				rst = prepareStatement.getResultSet();
				resultList = praseResultSetToListBean(rst,className);
			}
		}catch(Exception e){
			logger.error("执行sql语句失败", e);
		}finally{
			try{
			prepareStatement.close();
			connect.close();
			}catch(Exception e){
				logger.error("执行sql发生异常", e);
			}
		}
		return resultList;
	}
	/**
	 * 执行sql，返回List对象
	  * @Title: queryForList 
	  * @Description: 
	  * @param sql
	  * @param params
	  * @return
	 */
	public static List<Map<String,Object>> queryForListMap(String sql,List<Object>... params){
		logger.debug("执行SQL语句开始：{}，参数内容是{}", sql,Arrays.toString(params));
		List<Map<String,Object>> resultList = new ArrayList<Map<String,Object>>();
		ResultSet rst=null;
		PreparedStatement prepareStatement=null;
		try{
			prepareStatement = connect.prepareStatement(sql);
			if(params.length>0){
				for(int i=0;i<params[0].size();i++){
					prepareStatement.setObject(i, params[0].get(i));
				}
			}
			boolean result = prepareStatement.execute();
			if(result){
				rst = prepareStatement.getResultSet();
				resultList = praseResultSetToListMap(rst);
			}
		}catch(Exception e){
			logger.error("执行sql语句失败", e);
		}finally{
			try{
			prepareStatement.close();
			connect.close();
			}catch(Exception e){
				logger.error("执行sql发生异常", e);
			}
		}
		return resultList;
	}
	private static List<Map<String,Object>> praseResultSetToListMap(ResultSet rst) throws SQLException{
		List<Map<String,Object>> resultList = new ArrayList<Map<String,Object>>();
		if(rst==null){
			logger.error("查询结果集为空不能进行数据封装");
			return resultList;
		}
		ResultSetMetaData metaData = rst.getMetaData();
		int columnCount = metaData.getColumnCount();
		while(rst.next()){
			Map<String,Object> resultMap = new HashMap<String, Object>();
			String columLabel="";
			for(int i=0;i<columnCount;i++){
				columLabel = metaData.getColumnLabel(i);
				resultMap.put(columLabel,rst.getObject(columLabel));
				logger.debug("封装结果内容，label='{}';value='{}';",columLabel,rst.getObject(columLabel));
			}
			resultList.add(resultMap);
		}
		return resultList;
	}
	@SuppressWarnings({"rawtypes"})
	private static<T> List<T> praseResultSetToListBean(ResultSet rst,Class beanClass) throws SQLException, InstantiationException, IllegalAccessException{
		List<T> resultList = new ArrayList<T>();
		if(rst==null){
			logger.error("查询结果集为空不能进行数据封装");
			return resultList;
		}
		ResultSetMetaData metaData = rst.getMetaData();
		int columnCount = metaData.getColumnCount();
		while(rst.next()){
			String columLabel="";
			T bean = (T) beanClass.newInstance();
			for(int i=0;i<columnCount;i++){
				columLabel = metaData.getColumnLabel(i+1);
				GuYueBeanUtil.setProperty(bean, columLabel, rst.getObject(columLabel));
				logger.debug("封装结果内容，label='{}';value='{}';",columLabel,rst.getObject(columLabel));
			}
			resultList.add(bean);
		}
		return resultList;
	}
	public static List<DBColumn> getDBColumns(String dbName,List<String> tableNamesList){
//		查找表信息注释信息
		String sql=getSqlBySqlDbType(DBTypeEnum.MYSQL,dbName,tableNamesList);
//		根据返回结果封装 
		return DatabaseUtil.queryForListBean(sql, DBColumn.class);
	}
	public static List<DBColumn> getDBColumns(String dbName){
//		查找表信息注释信息
		String sql=getSqlBySqlDbType(DBTypeEnum.MYSQL,dbName,null);
//		根据返回结果封装 
		return DatabaseUtil.queryForListBean(sql, DBColumn.class);
	}
	public static Map<String,List<DBColumn>> getDBTables(String dbName){
		Map<String,List<DBColumn>> tableMap = new HashMap<String, List<DBColumn>>();
		List<DBColumn> dBColumns = getDBColumns(dbName);
		for(DBColumn dbColumn:dBColumns){
			if(tableMap.containsKey(dbColumn.getColumnTableName())){
				tableMap.get(dbColumn.getColumnTableName()).add(dbColumn);
			}else{
				List<DBColumn> tableColumnList = new ArrayList<DBColumn>();
				tableColumnList.add(dbColumn);
				tableMap.put(dbColumn.getColumnTableName(), tableColumnList);
			}
		}
		return tableMap;
	}
	public static Map<String,List<DBColumn>> getDBTables(List<DBColumn> dBColumns){
		Map<String,List<DBColumn>> tableMap = new HashMap<String, List<DBColumn>>();
		for(DBColumn dbColumn:dBColumns){
			if(tableMap.containsKey(dbColumn.getColumnTableName())){
				tableMap.get(dbColumn.getColumnTableName()).add(dbColumn);
			}else{
				List<DBColumn> tableColumnList = new ArrayList<DBColumn>();
				tableColumnList.add(dbColumn);
				tableMap.put(dbColumn.getColumnTableName(), tableColumnList);
			}
		}
		return tableMap;
	}
	private static String getSqlBySqlDbType(DBTypeEnum db,String dbName,List<String> tableName){
		String sql = "";
		if(DBTypeEnum.MYSQL.equals(db)){
			sql = "select TABLE_SCHEMA as columnDbName,TABLE_NAME as columnTableName,COLUMN_NAME as columnName,DATA_TYPE as columnType, CHARACTER_MAXIMUM_LENGTH as columnMaxLength,COLUMN_KEY as columnPRI,EXTRA as columnAutoInCrement,COLUMN_COMMENT as columnComment from information_schema.COLUMNS WHERE TABLE_SCHEMA = '"+dbName+"'";
		}
		String sqlIn = getSqlInStr(tableName);
		if(StringUtil.isNotEmpty(sqlIn)){
			sql+=" AND TABLE_NAME "+sqlIn;
		}
		return sql;
	}
	private static<T> String getSqlInStr(List<T> inElmentsList){
		GuyueStringBuffer sqlInSb = new GuyueStringBuffer();
		boolean hasElments=inElmentsList!=null&&!inElmentsList.isEmpty();
		if(!hasElments){
			return sqlInSb.toString();
		}
		for(T elment:inElmentsList){
			if(elment instanceof String){
				sqlInSb.append("'");
				sqlInSb.append((String)elment);
				sqlInSb.append("',");
			}
			if(elment instanceof Integer){
				sqlInSb.append(elment.toString());
				sqlInSb.append(",");
			}
		}
		if(sqlInSb.isNotEmpty()){
			sqlInSb.insert(0, " in (");
			sqlInSb.deleteCharAt(sqlInSb.length());
			sqlInSb.append(") 	");
		}
		return sqlInSb.toString();
	}
}

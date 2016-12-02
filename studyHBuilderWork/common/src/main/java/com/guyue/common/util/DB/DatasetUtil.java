package com.guyue.common.util.DB;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import org.slf4j.Logger;

import com.guyue.common.util.GuyueLoggerFactory;
import com.guyue.common.util.StringUtil;
import com.guyue.common.util.classload.ClassLoadUtil;
import com.guyue.common.vo.DBConnecttion;

public class DatasetUtil {
	private static Logger logger = GuyueLoggerFactory.getLogger(DatasetUtil.class);
	public static Connection getConnect(DBConnecttion connection){
		if(StringUtil.isNotEmpty(connection.getJdbcJarPath())){
//			根据jar包路径加载驱动类
			ClassLoadUtil.loadClassByJarPath(connection.getJdbcJarPath());
		}
		Connection connect=null;
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
	public ResultSet execSql(DBConnecttion connection,String sql,Object[] params){
		ResultSet rst=null;
		Connection conn = getConnect(connection);
		PreparedStatement prepareStatement=null;
		try{
			prepareStatement = conn.prepareStatement(sql);
			if(params!=null){
				for(int i=0;i<params.length;i++){
					prepareStatement.setObject(i, params[i]);
				}
			}
			boolean result = prepareStatement.execute();
			if(result){
				rst = prepareStatement.getResultSet();
				rst.next();
			}
		}catch(Exception e){
			logger.error("执行sql语句失败", e);
		}finally{
			try{
			prepareStatement.close();
			conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return rst;
		
	}
}

package com.guyue.project.ProjectMannger.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.guyue.common.util.GuyueStringBuffer;
import com.guyue.common.util.StringUtil;

public class ExcelTables {
	private String tableId;
	private String tableDb;
	private String tableName;
	List<String> columnCreateTableSql;
	List<Map<Integer,String>> initDate;
	Map<Integer,String> initDateColumn;
	public ExcelTables(String tableId){
		this.tableId=tableId;
	}
	public String getTableId() {
		return tableId;
	}
	public String getTableDb() {
		return tableDb;
	}
	public void setTableDb(String tableDb) {
		this.tableDb = tableDb;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public List<String> getColumnCreateTableSql() {
		if(columnCreateTableSql==null){
			columnCreateTableSql = new ArrayList<String>();
		}
		return columnCreateTableSql;
	}
	public void setColumnCreateTableSql(List<String> columnCreateTableSql) {
		this.columnCreateTableSql = columnCreateTableSql;
	}
	public List<Map<Integer, String>> getInitDate() {
		if(initDate==null){
			initDate = new ArrayList<Map<Integer,String>>();
		}
		return initDate;
	}
	public void setInitDate(List<Map<Integer, String>> initDate) {
		this.initDate = initDate;
	}
	public Map<Integer, String> getInitDateColumn() {
		return initDateColumn;
	}
	public void setInitDateColumn(Map<Integer, String> excelDataMap) {
		this.initDateColumn = excelDataMap;
	}
	/**
	 * 获取建表语句
	  * @Title: getCreateTablesSql 
	  * @Description: 
	  * @return
	 */
	public String getCreateTablesSql(){
		GuyueStringBuffer createSql = new GuyueStringBuffer();
		createSql.appendln("DROP TABLE IF EXISTS "+this.tableName+";");
		createSql.appendln("CREATE TABLE "+this.tableName+" (");
		for(String columnCreateSql:this.columnCreateTableSql){
			createSql.appendln(columnCreateSql);
		}
		createSql.appendln("        PRIMARY KEY (id)");
		createSql.appendln(") ENGINE=InnoDB DEFAULT CHARSET=utf8 ;");
		return createSql.toString();
	}
	public String getInitDataSql(){
		if(initDate==null||initDate.size()<1||initDateColumn==null){
			return null;
		}
		GuyueStringBuffer initDataSql = new GuyueStringBuffer();
		for(Map<Integer,String> insertData:initDate){
			initDataSql.append("INSERT INTO "+this.getTableName()+"(");
			for(String columnName:initDateColumn.values()){
				initDataSql.append(""+columnName);
				initDataSql.append(",");
			}
			initDataSql.deleteCharAt(initDataSql.length()-1);
			initDataSql.append(") VALUES(");
			for(Entry<Integer,String> entry:initDateColumn.entrySet()){
				String columnName = entry.getValue();
				if(columnName.startsWith("c_")||columnName.startsWith("C_")){
					initDataSql.append("'");
					initDataSql.append(StringUtil.praseNullString(insertData.get(entry.getKey())));
					initDataSql.append("'");
				}
				if(columnName.startsWith("n_")||columnName.startsWith("N_")){
					initDataSql.append(insertData.get(entry.getKey()));
				}
				initDataSql.append(",");
			}
			initDataSql.deleteCharAt(initDataSql.length()-1);
			initDataSql.appendln(");");
		}
		return initDataSql.toString();
	}
}

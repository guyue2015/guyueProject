package com.guyue.project.ProjectMannger.create.sql;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.guyue.common.util.FileUtil;
import com.guyue.common.util.GuyueStringBuffer;
import com.guyue.common.util.StringUtil;
import com.guyue.common.util.office.ExcelUtil;

public class CreateMySQLFromExcel {
	public static void createMysqlFromExcel(Path excelPath,Path sqlPath){
		Map<String, String> readDbSqls = readExcel(excelPath);
		for(Entry<String,String> entry:readDbSqls.entrySet()){
			String databaseName = entry.getKey();
			String sqlContext = entry.getValue();
//			写入指定路径
			Path sqlFilePath = Paths.get(sqlPath.toString(), databaseName+".sql");
			FileUtil.deleteFile(sqlFilePath);
			sqlContext="DROP DATABASE IF EXISTS "+databaseName+";\n"
			+"CREATE DATABASE "+databaseName+";\n"
			+"USE "+databaseName+";\n"+sqlContext;
			FileUtil.writeFile(sqlFilePath, sqlContext);
		}
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map<String,String> readExcel(Path excelPath){
		Map<String,String> dbMap = new HashMap<String, String>();
		String tableName = "";
		String dbName = "";
		String comments="";
		GuyueStringBuffer createTableSql = new GuyueStringBuffer();
		Map<String, List> readExcel = ExcelUtil.readExcel(excelPath);
		for(Entry entry:readExcel.entrySet()){
			List<Map<String,String>> excelList = (List<Map<String, String>>) entry.getValue();
				int size = excelList.size();
				for(Map<String,String> cellMap:excelList){
					size--;
					if("库名".equals(cellMap.get("0"))){
						continue;
					}
					if(StringUtil.isEmpty(tableName)){
						tableName = cellMap.get("1");
						dbName = cellMap.get("0");
						createTableSql.appendln("DROP TABLE IF EXISTS "+tableName+";");
						createTableSql.appendln("create table "+tableName+" (");
					}
					if(!tableName.equals(cellMap.get("1"))){
						createTableSql.appendln("        PRIMARY KEY (id)");
						createTableSql.appendln(")CHARACTER SET utf8 COLLATE utf8_general_ci;");
						String dbSql = dbMap.get(dbName);
						if(StringUtil.isEmpty(dbSql)){
							dbSql="";
						}
						dbMap.put(dbName, dbSql+"\n"+createTableSql);
						createTableSql.clear();
						dbName = cellMap.get("0");
						tableName = cellMap.get("1");
						createTableSql.appendln("DROP TABLE IF EXISTS "+tableName+";");
						createTableSql.appendln("create table "+tableName+" (");
					}
					if(cellMap.get("2").equalsIgnoreCase("id")){
						createTableSql.append("        "+cellMap.get("2")+" "+cellMap.get("3")+" NOT NULL AUTO_INCREMENT");
					}else{
						createTableSql.append("        "+cellMap.get("2")+" "+cellMap.get("3"));
					}
					if(cellMap.containsKey("4")&&StringUtil.isNotEmpty(cellMap.containsKey("4"))){
						comments = cellMap.get("4");
					}
					if(cellMap.containsKey("5")&&StringUtil.isNotEmpty(cellMap.containsKey("5"))){
						comments += cellMap.get("5");
					}
					if(StringUtil.isNotEmpty(comments)){
						createTableSql.append(" comment '"+comments+"'");
					}
					createTableSql.appendln(",");
					if(size==0){
						createTableSql.appendln("        PRIMARY KEY (id)");
						createTableSql.appendln(")CHARACTER SET utf8 COLLATE utf8_general_ci;");
						String dbSql = dbMap.get(cellMap.get("0"));
						if(StringUtil.isEmpty(dbSql)){
							dbSql="";
						}
						dbMap.put(cellMap.get("0"), dbSql+"\n"+createTableSql);
					}
				}
		}
		return dbMap;
	}
}

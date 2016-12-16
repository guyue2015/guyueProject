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
import com.guyue.project.ProjectMannger.vo.ExcelTables;

public class CreateMySQLFromExcel {
	/**
	 * excel sheeet tables index 0
	 */
	private static String DB_EXCEL_SHEET_INDEX_TABLES = "0";
	/**
	 * excel sheeet tablescolumn index 1
	 */
	private static String DB_EXCEL_SHEET_INDEX_TABLES_COLUMNS = "1";
	/**
	 * excel sheeet tablesdata index 2
	 */
	private static String DB_EXCEL_SHEET_INDEX_TABLES_DATA = "2";

	public static void createMysqlFromExcel(Path excelPath, Path sqlPath) {
		Map<String, ExcelTables> readDbSqls = readExcel(excelPath);
		Map<String,String> fileSql = new HashMap<String, String>();
		 for(Entry<String,ExcelTables> entry:readDbSqls.entrySet()){
			 ExcelTables excelTable = entry.getValue();
			 String createTablseSqlContext = excelTable.getCreateTablesSql();
			 String initTableDataSqlContext = excelTable.getInitDataSql();
//		  	写入指定路径
			 String dbCreateFile = excelTable.getTableDb()+"/Tables.sql";
			 String dbInitFile = excelTable.getTableDb()+"/Init.sql";
			 if(fileSql.containsKey(dbCreateFile)&&StringUtil.isNotEmpty(createTablseSqlContext)){
				 createTablseSqlContext = fileSql.get(dbCreateFile)+createTablseSqlContext;
			 }
			 if(fileSql.containsKey(dbInitFile)&&StringUtil.isNotEmpty(initTableDataSqlContext)){
				 initTableDataSqlContext = fileSql.get(dbInitFile)+initTableDataSqlContext;
			 }
			 if(!fileSql.containsKey(dbCreateFile)&&StringUtil.isNotEmpty(createTablseSqlContext)){
				 GuyueStringBuffer dbHeader = new GuyueStringBuffer();
				 dbHeader.appendln("DROP DATABASE IF EXISTS "+excelTable.getTableDb()+";");
				 dbHeader.appendln("CREATE DATABASE "+excelTable.getTableDb()+";");
				 dbHeader.appendln("USE "+excelTable.getTableDb()+";");
				 createTablseSqlContext = dbHeader.toString()+createTablseSqlContext;
			 }
			 if(!fileSql.containsKey(dbInitFile)&&StringUtil.isNotEmpty(initTableDataSqlContext)){
				 initTableDataSqlContext = "USE "+excelTable.getTableDb()+";\n"+initTableDataSqlContext;
			 }
			 if(StringUtil.isNotEmpty(createTablseSqlContext)){
				 fileSql.put(dbCreateFile, createTablseSqlContext);
			 }
			 if(StringUtil.isNotEmpty(initTableDataSqlContext)){
				 fileSql.put(dbInitFile, initTableDataSqlContext);
			 }
		 }
		 for(String fileName:fileSql.keySet()){
			 Path sqlFilePath = Paths.get(sqlPath.toString(), fileName);
			 if(FileUtil.exists(sqlFilePath)){
				 FileUtil.deleteFile(sqlFilePath);
			 }else{
				 FileUtil.createFile(sqlFilePath);
			 }
			 FileUtil.writeFile(sqlFilePath, fileSql.get(fileName));
		 }
	}
	@SuppressWarnings({"rawtypes", "unchecked"})
	public static Map<String, ExcelTables> readExcel(Path excelPath) {
		Map<String, ExcelTables> excelTablesMap = new HashMap<String, ExcelTables>();
		Map<String, List> readExcel = ExcelUtil.readExcel(excelPath);
		ExcelTables excelTables = null;
		for (Entry<String, List> entry : readExcel.entrySet()) {
			String sheetIndex = entry.getKey();
			List<Map<String, String>> excelList = (List<Map<String, String>>) entry
					.getValue();
			for (Map<String, String> excelDataMap : excelList) {
				if ("tableid".equalsIgnoreCase(excelDataMap.get("0"))) {// 跳过第一行
					continue;
				}
				if (excelTablesMap.containsKey(excelDataMap.get("0"))) {
					excelTables = excelTablesMap.get(excelDataMap.get("0"));
				} else {
					excelTables = new ExcelTables(excelDataMap.get("0"));
					excelTablesMap.put(excelDataMap.get("0"), excelTables);
				}
				if (DB_EXCEL_SHEET_INDEX_TABLES.equals(sheetIndex)) {
					praseTables(excelTables, excelDataMap);
				} else if (DB_EXCEL_SHEET_INDEX_TABLES_COLUMNS
						.equals(sheetIndex)) {
					praseTablesColumn(excelTables, excelDataMap);
				} else if (DB_EXCEL_SHEET_INDEX_TABLES_DATA.equals(sheetIndex)) {
					praseTablesData(excelTables, excelDataMap);
				}
			}
		}
		return excelTablesMap;
	}
	private static void praseTablesData(ExcelTables excelTables,
			Map<String, String> excelDataMap) {
		if(excelDataMap.containsKey("1")&&"1".equals(excelDataMap.get("1"))){
			excelTables.setInitDateColumn(excelDataMap);
		}else{
			excelTables.getInitDate().add(excelDataMap);
		}
		excelDataMap.remove("0");
		excelDataMap.remove("1");
	}
	private static void praseTablesColumn(ExcelTables excelTables,
			Map<String, String> excelDataMap) {
		String comments = "";
		if (excelDataMap.containsKey("4")) {
			comments+=excelDataMap.get("4");
		}
		if (excelDataMap.containsKey("5")) {
			comments+=excelDataMap.get("5");
		}
		GuyueStringBuffer sql = new GuyueStringBuffer();
		sql.append("        "+excelDataMap.get("2")+"  "+excelDataMap.get("3"));
		if("id".equalsIgnoreCase(excelDataMap.get("2"))){
			sql.append("  NOT NULL AUTO_INCREMENT  ");
		}
		if(StringUtil.isNotEmpty(comments)){
			sql.append("  COMMENT '"+comments+"'");
		}
		sql.append(",");
		excelTables.getColumnCreateTableSql().add(sql.toString());
	}
	private static void praseTables(ExcelTables excelTables,
			Map<String, String> excelDataMap) {
		excelTables.setTableDb(excelDataMap.get("1"));
		excelTables.setTableName(excelDataMap.get("2"));
	}

}

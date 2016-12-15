package com.guyue.common.util.office;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	private static String EXCEL_PERFIX_2003=".xls";
	public Map<String,List> readExcel(Path excelPath){
		Map<String,List> workBookMap = new HashMap<String, List>();
		List<Map<String,String>> excelDataList = null;
		Map<String,String> rowMap = null;
		try {
			InputStream excelInStream = Files.newInputStream(excelPath,StandardOpenOption.READ);
			Workbook workbook = getWorkBook(excelPath);
			int sheetNum = workbook.getActiveSheetIndex();
			for(int i=0;i<sheetNum;i++){
				excelDataList = new ArrayList<Map<String,String>>();
				Sheet sheetAt = workbook.getSheetAt(i);
				int rowNum = sheetAt.getPhysicalNumberOfRows();
				for(int j=0;j<rowNum;j++){
					Row row = sheetAt.getRow(j);
					rowMap = new HashMap<String, String>();
					int columnNum = row.getPhysicalNumberOfCells();
					for(int k=0;k<columnNum;k++){
						Cell cell = row.getCell(k);
						rowMap.put(""+k,cell.getStringCellValue());
					}
					excelDataList.add(rowMap);
				}
				workBookMap.put(""+i, excelDataList);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return workBookMap;
	}
	private Workbook getWorkBook(Path excelPath) {
		InputStream excelInStream;
		try {
			excelInStream = Files.newInputStream(excelPath,StandardOpenOption.READ);
			if(excelPath.toString().endsWith(EXCEL_PERFIX_2003)){
				HSSFWorkbook workbook = new HSSFWorkbook(excelInStream);
				return workbook;
			}else{
				XSSFWorkbook xworkbook = new XSSFWorkbook(excelInStream);
				return xworkbook;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}

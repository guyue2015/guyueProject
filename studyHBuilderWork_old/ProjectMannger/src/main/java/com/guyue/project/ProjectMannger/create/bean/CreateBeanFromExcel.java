package com.guyue.project.ProjectMannger.create.bean;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import com.guyue.common.util.GuyueStringBuffer;
import com.guyue.common.util.StringUtil;
import com.guyue.common.util.office.ExcelUtil;

public class CreateBeanFromExcel {
	/**
	 * 
	  * @Title: createBeanFromExcel 
	  * @Description: 
	  * @param excelHeadDefine
	  *        该集合定义了 excel字段列与属性对应关系 excel第一列为1
	  *        目前的key为3个：propertyName,propertyType,propertyComment
	  * @param isContainFirstRow
	  * @param excelPath
	  * @param sheetIndex
	 */
	public static String propertyName_KEY ="propertyName";
	public static String propertyType_KEY ="propertyType";
	public static String propertyComment_KEY ="propertyComment";
	public static String propertyTestValue_KEY ="propertyTestValue";
	
	public static void createBeanFromExcel(Map<String,Integer> excelHeadDefine,boolean isContainFirstRow,Path excelPath,Integer sheetIndex){
		Map<Integer, List<Map<Integer, String>>> readDataExcel = ExcelUtil.readExcel(excelPath);
		List<Map<Integer, String>> rowMapList = readDataExcel.get(sheetIndex.toString());
		Map<Integer, String> rowMap=null;
		String propertyName="";
		String propertyType="";
		String propertyComment="";
		String propertyTestValue="";
		GuyueStringBuffer propertySB = new GuyueStringBuffer();
		GuyueStringBuffer propertyMethodSB = new GuyueStringBuffer();
		GuyueStringBuffer propertyJsonTestStringSb = new GuyueStringBuffer();
		propertyJsonTestStringSb.append("{");
		for(int i=0;i<rowMapList.size();i++){
			if(i==0&&!isContainFirstRow){
				continue;
			}
			rowMap = rowMapList.get(i);
			
			propertyName = rowMap.get(""+excelHeadDefine.get(propertyName_KEY));
			
			propertyType = rowMap.get(""+excelHeadDefine.get(propertyType_KEY));
			
			propertyComment = rowMap.get(""+excelHeadDefine.get(propertyComment_KEY));
			propertyTestValue = rowMap.get(""+excelHeadDefine.get(propertyTestValue_KEY));
			appendJsonTestValue(propertyJsonTestStringSb, propertyName, propertyType, propertyComment,propertyTestValue);
			appendProperty(propertySB,propertyName,propertyType,propertyComment);
			appendMethod(propertyMethodSB,propertyName,propertyType,propertyComment);
		}
		if(propertyJsonTestStringSb.toString().endsWith(",")){
			propertyJsonTestStringSb.deleteCharAt(propertyJsonTestStringSb.length()-1);
		}
		propertyJsonTestStringSb.append("}");
		System.out.println(propertyJsonTestStringSb.toString());
		System.out.println(propertySB.toString());
		System.out.println(propertyMethodSB.toString());
	}

	private static void appendJsonTestValue(
			GuyueStringBuffer propertyJsonTestStringSb, String propertyName,
			String propertyType, String propertyComment, String propertyTestValue) {
		if(replace_AndFirstUp(propertyType,true).equals("String")){
			propertyJsonTestStringSb.append("\"");
			propertyJsonTestStringSb.append(propertyName);
			propertyJsonTestStringSb.append("\":");
			propertyJsonTestStringSb.append(StringUtil.isEmpty(propertyTestValue)?"\"\"":"\""+propertyTestValue+"\"");
		}else if(replace_AndFirstUp(propertyType,true).equals("Integer")){
			propertyJsonTestStringSb.append(propertyName+":"+propertyTestValue);
		}else{
			return;
		}
		propertyJsonTestStringSb.append(",");
	}

	private static void appendProperty(GuyueStringBuffer propertySB,
			String propertyName, String propertyType, String propertyComment) {
		String propertyNameTemp = replace_AndFirstUp(propertyName,false);
		propertySB.appendln("/**");
		propertySB.appendln(brockStr(propertyComment));
		propertySB.appendln("*/");
		propertySB.appendln("@SerializedName(\""+propertyName+"\")");
		propertySB.appendln("private "+replace_AndFirstUp(propertyType,true)+" "+propertyNameTemp+";");
	}

	private static String brockStr(String propertyComment){
		GuyueStringBuffer result=new GuyueStringBuffer();
		for(int i =0;i<propertyComment.length();i=i+30){
			if(propertyComment.length()<=i+30){
				result.appendln("* "+propertyComment.substring(i, propertyComment.length()));
			}else{
				result.appendln("* "+propertyComment.substring(i, i+30));
			}
		}
		return result.toString();
	}
	private static String replace_AndFirstUp(String propertyName,boolean upcaseFirstChar) {
		String result = "";
		String[] subStr = propertyName.split("_");
		for(int i=0;i<subStr.length;i++){
			if(i==0&&!upcaseFirstChar){
				result+=subStr[i];
			}else{
				result += subStr[i].substring(0,1).toUpperCase()+subStr[i].substring(1);
			}
		}
		return result;
	}

	private static void appendMethod(GuyueStringBuffer propertyMethodSB,
			String propertyName, String propertyType, String propertyComment) {
		String getpropertyName = "get"+replace_AndFirstUp(propertyName,true);
		String setpropertyName = "set"+replace_AndFirstUp(propertyName,true);
		propertyMethodSB.appendln("/**");
		propertyMethodSB.appendln("* 获取 属性 "+replace_AndFirstUp(propertyName,false));
		propertyMethodSB.appendln(brockStr(propertyComment));
		propertyMethodSB.appendln("* @param "+replace_AndFirstUp(propertyName,false));
		propertyMethodSB.appendln("*/");
		propertyMethodSB.appendln("public "+replace_AndFirstUp(propertyType,true)+" "+getpropertyName+"(){");
		propertyMethodSB.appendln("return this."+replace_AndFirstUp(propertyName,false)+";");
		propertyMethodSB.appendln("}");
		propertyMethodSB.appendln("/**");
		propertyMethodSB.appendln("* 设置 属性 "+replace_AndFirstUp(propertyName,false));
		propertyMethodSB.appendln(brockStr(propertyComment));
		propertyMethodSB.appendln("* @param "+replace_AndFirstUp(propertyName,false));
		propertyMethodSB.appendln("*/");
		propertyMethodSB.appendln("public void "+setpropertyName+"("+replace_AndFirstUp(propertyType,true)+" "+replace_AndFirstUp(propertyName,false)+"){");
		propertyMethodSB.appendln("this."+replace_AndFirstUp(propertyName,false)+"="+replace_AndFirstUp(propertyName,false)+";");
		propertyMethodSB.appendln("}");
	}
}

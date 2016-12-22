package com.guyue.project.ProjectMannger.create.mybaties;

import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSONObject;

import com.guyue.common.util.FileUtil;
import com.guyue.common.util.StringUtil;

public class JavaFilePase {
	private static int code_level = 0;
	private static List<JSONObject> methodList = new ArrayList<JSONObject>();
	private static List<JSONObject> methodResultList = new ArrayList<JSONObject>();
	public static void main(String[] args) {
		String filename="C:\\guyue\\gitForme\\studyHBuilderWork\\ProjectMannger\\src\\main\\java\\com\\guyue\\project\\ProjectMannger\\create\\sql\\CreateMySQLFromExcel.java";
		Path javaFilePath = FileSystems.getDefault().getPath(filename);
		List<String> javaFileStrings = FileUtil.readFileForList(javaFilePath, Charset.defaultCharset());
		String lineContext="";
		for(int lineNumber=0;lineNumber<javaFileStrings.size();lineNumber++){
			lineContext = javaFileStrings.get(lineNumber);
			if(isContainBranceLeft(lineContext)){
				code_level++;
				if(code_level==2){
					JSONObject methodJson = new JSONObject();
					String methodName = getMethodName(lineContext);
					if(StringUtil.isEmpty(methodName)){
						lineContext = javaFileStrings.get(lineNumber-1)+javaFileStrings.get(lineNumber);
						methodName = getMethodName(lineContext);
					}
					if(StringUtil.isNotEmpty(methodName)){
						methodName = methodName.replaceAll("\\s{1,}", " ").replace("{", "").trim();
					}
					methodJson.put("methodName", methodName);
					methodJson.put("startLine", lineNumber+1);
					methodList.add(methodJson);
				}
			}
			if(isContainBranceRight(lineContext)){
				if(code_level>0){
					code_level--;
				}
				if(code_level==2&&methodList.size()>0){
					JSONObject methodJson = methodList.get(methodList.size()-1);
					methodJson.put("endLine", lineNumber+1);
					methodJson.put("methodCountLine", ((lineNumber+1)-(int)methodJson.get("startLine")));
					methodResultList.add(methodJson);
					methodList.remove(methodList.size()-1);
				}
			}
		}
		for(JSONObject methodJson:methodResultList){
			System.out.println("methodName:"+methodJson.getString("methodName")+",startLine:"+methodJson.getString("startLine")+",methodCountLine:"+methodJson.getString("methodCountLine"));
		}
	}

	private static String getMethodName(String lineContext) {
		String methodName="";
		Pattern methodReg = Pattern.compile("[ ]{1}.*[(]{1}.*[)]{1}.*[{]");
		Matcher mehodMatch = methodReg.matcher(lineContext);
		if(mehodMatch.find()){
			methodName = mehodMatch.group();
		}
		return methodName;
	}

	public static boolean isContainBranceLeft(String context) {
		if (StringUtil.isNotEmpty(context) && context.contains("{")&&!context.contains("@")) {
			return true;
		}
		return false;
	}

	public static boolean isContainBranceRight(String context) {
		if (StringUtil.isNotEmpty(context) && context.contains("}")&&!context.contains("@")) {
			return true;
		}
		return false;
	}
}

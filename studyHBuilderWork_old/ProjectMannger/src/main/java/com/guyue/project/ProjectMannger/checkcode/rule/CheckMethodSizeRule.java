package com.guyue.project.ProjectMannger.checkcode.rule;

import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSONObject;

import com.guyue.common.util.FileUtil;
import com.guyue.common.util.StringUtil;

public class CheckMethodSizeRule implements Rule{
	private static int method_bad_lineCount=200;
	public List<JSONObject> notRightList= new ArrayList<JSONObject>();
	public CheckMethodSizeRule(){
		notRightList.clear();
	}
	@Override
	public String getFileSuffix() {
		return ".java";
	}
	@Override
	public void checkRule(Path javaFilePath) {
		int code_level = 0;
		List<JSONObject> methodList = new ArrayList<JSONObject>();
		List<JSONObject> methodResultList = new ArrayList<JSONObject>();
		if(javaFilePath.toString().endsWith(getFileSuffix())){
			List<String> javaFileStrings = FileUtil.readFileForList(javaFilePath, Charset.defaultCharset());
			String lineContext="";
			for(int lineNumber=0;lineNumber<javaFileStrings.size();lineNumber++){
				lineContext = javaFileStrings.get(lineNumber);
				String lastLine="";
				if(lineNumber>1){
					lastLine = javaFileStrings.get(lineNumber-1);
				}
				if(isContainBranceLeft(lineContext,lastLine)){
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
				if(isContainBranceRight(lineContext,lastLine)){
					if(code_level>0){
						code_level--;
					}
					if(code_level==2&&methodList.size()>0){
						JSONObject methodJson = methodList.get(methodList.size()-1);
						int methodCountLine =(lineNumber+1)-(int)methodJson.get("startLine");
						methodJson.put("endLine", lineNumber+1);
						methodJson.put("methodCountLine", methodCountLine);
						if(methodCountLine>method_bad_lineCount){
							methodResultList.add(methodJson);
						}
						methodList.remove(methodList.size()-1);
					}
				}
			}
			for(JSONObject methodJson:methodResultList){
				System.out.println(getErrorInfo(javaFilePath.toString(),methodJson.getString("methodName"),methodJson.getString("startLine"),methodJson.getString("methodCountLine")));
			}
		}
		notRightList.addAll(methodResultList);
	}
	@Override
	public String getErrorInfo(Object... errorInfo) {
		return String.format("文件路径{%s},方法名{%s},方法开始行{%s}方法共{%s}行,违反方法过长", errorInfo);
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
	public static boolean isContainBranceLeft(String context, String lastLine) {
		boolean isAnountion=context.trim().startsWith("@")&&!lastLine.endsWith("(")&&!lastLine.endsWith(",");
		if (StringUtil.isNotEmpty(context) && context.contains("{")&&!isAnountion) {
			return true;
		}
		return false;
	}

	public static boolean isContainBranceRight(String context, String lastLine) {
		boolean isAnountion=context.trim().startsWith("@")&&!lastLine.endsWith("(")&&!lastLine.endsWith(",");
		if (StringUtil.isNotEmpty(context) && context.contains("}")&&!isAnountion) {
			return true;
		}
		return false;
	}
}

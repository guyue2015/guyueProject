package com.guyue.project.ProjectMannger.checkcode.rule;

import java.nio.file.Path;
import java.util.List;

import com.guyue.common.util.FileUtil;

public class CheckMethodSizeRule implements Rule{
	private static int cengji=1;
	private static int checkMethodSize=500;
	@Override
	public String getFileSuffix() {
		return ".java";
	}
	@Override
	public void checkRule(Path filePath) {
		List<String> readFileForList;
		if(filePath.toString().endsWith(getFileSuffix())){
			readFileForList = FileUtil.readFileForList(filePath);
			for(int lineNumber=0;lineNumber<readFileForList.size();lineNumber++){
				
//					System.out.println(getErrorInfo(filePath.toString(),lineNumber+1));
			}
		}
	}
	@Override
	public String getErrorInfo(Object... errorInfo) {
		return String.format("文件路径{%s},方法名{%s},方法体长度{%s},违反方法过长", errorInfo);
	}
	
}

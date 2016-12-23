package com.guyue.project.ProjectMannger.checkcode.rule;

import java.nio.file.Path;
import java.util.List;

import com.guyue.common.util.FileUtil;

public class CheckExceptionOutRule implements Rule{

	private static String FILE_SUFFIX=".java";
	@Override
	public String getFileSuffix() {
		return FILE_SUFFIX;
	}
	@Override
	public void checkRule(Path filePath) {
		List<String> readFileForList;
		if(filePath.toString().endsWith(getFileSuffix())){
			readFileForList = FileUtil.readFileForList(filePath);
			for(int lineNumber=0;lineNumber<readFileForList.size();lineNumber++){
				if(readFileForList.get(lineNumber).contains("e.printStackTrace();")){
					System.out.println(getErrorInfo(filePath.toString(),lineNumber+1));
				}
			}
		}
	}
	@Override
	public String getErrorInfo(Object... errorInfo) {
		return String.format("出错文件路径:{%s},错误行号:{%s},违反规则信息：出现 e.printStackTrace(),该语句输出到控制台，无法记录到日志内容中", errorInfo);
//		return "";
	}
}

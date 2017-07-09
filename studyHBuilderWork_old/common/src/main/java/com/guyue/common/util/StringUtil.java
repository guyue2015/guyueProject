package com.guyue.common.util;

import org.springframework.util.StringUtils;

public class StringUtil {
	/**
	 * 判断是空
	  * @Title: isEmpty 
	  * @Description: 
	  * @param str
	  * @return
	 */
	public static boolean isEmpty(Object str){
		return StringUtils.isEmpty(str);
	}
	/**
	 * 判断非空
	  * @Title: isNotEmpty 
	  * @Description: 
	  * @param str
	  * @return
	 */
	public static boolean isNotEmpty(Object str){
		return !StringUtils.isEmpty(str);
	}
	/**
	 * 如果字符串==null,返回""
	  * @Title: praseNullString 
	  * @Description: 
	  * @param str
	  * @return
	 */
	public static String praseNullString(String str){
		return str==null?"":str;
	}
}

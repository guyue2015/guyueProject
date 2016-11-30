package com.guyue.common.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 *
 * @author huhedong
 *
 * 2016年11月19日
 */
public class DateUtil {
	public static DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/**
	 * 格式化时间 
	 * @param date
	 * @return
	 */
	public static String praseDate(Date date){
		return df.format(date);
	}
}

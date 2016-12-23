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
	public static DateFormat df_ymd = new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * 格式化时间 
	 * @param date
	 * @return
	 */
	public static String praseDateymdhms(Date date){
		return df.format(date);
	}
	/**
	 * 格式化时间 
	 * @param date
	 * @return
	 */
	public static String praseDateymd(Date date){
		return df_ymd.format(date);
	}
}

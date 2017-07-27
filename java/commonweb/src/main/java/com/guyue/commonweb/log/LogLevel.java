package com.guyue.commonweb.log;

public enum LogLevel {
	/**
	 * debug日志级别
	 */
	DEBUG(1,"debug日志级别"),
	/**
	 * info 日志级别
	 */
	INFO(2,"info日志级别"),
	/**
	 * error日志级别
	 */
	ERROR(3,"error日志级别"),
	/**
	 * 错误并发送短信给某一个人
	 */
	ERROR_AND_SMS(4,"错误并且发送短信级别"),
	/**
	 * 错误并发送短信以及邮件
	 */
	ERROR_AND_SMS_EMAIL(5,"发送短信以及发送邮件")
	;
	private Integer value;
	
	private String desc;
	
	LogLevel(Integer value,String desc){
		this.value=value;
		this.desc=desc;
	}
}

package com.guyue.guyueweb.log.center.vo;

import java.util.Map;

import lombok.Data;
/**
 * log相关内容
 * @author Administrator
 *
 */
@Data
public class ReceiveLogVo {
	private String logId;
	private String reqId;
	private String serverId;
	/***格式yyyy-MM-dd hh:mm:ss***/
	private String recordTime;
	/**日志类型 1:method,2:sql,3:exception,4:business**/
	private Integer logType;
	
	private Map<String,Object> logBody;
}

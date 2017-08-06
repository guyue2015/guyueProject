package com.guyue.guyueweb.log.center.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.guyue.commonweb.BasePackage.ApiResult;
import com.guyue.guyueweb.log.center.service.ReceiveLogService;
import com.guyue.guyueweb.log.center.vo.ReceiveLogVo;

@RestController
@RequestMapping("logcenter/receive")
public class ReceiveLogContrller {
	@Autowired
	private ReceiveLogService receiveLogService;
	
	/**
	 * 接收收到的日志信息
	 * @param receiveLog
	 * @return
	 */
	@RequestMapping(value="",method =RequestMethod.POST)
	public ApiResult reciveLog(@RequestBody ReceiveLogVo receiveLog){
		return receiveLogService.saveLog(receiveLog);
	}
	/**
	 * 项目启动时，获取该sever配置信息
	 * @param serverName
	 * @return
	 */
	@RequestMapping(value="queryServer",method =RequestMethod.GET)
	public ApiResult reciveLog(String serverName){
		return receiveLogService.selectServerByServerName(serverName);
	}
	/***
	 * 分析接受到的log
	 * @return
	 */
	public ApiResult analyseServerLog(){
		return receiveLogService.analyseServerLog();
	}
}

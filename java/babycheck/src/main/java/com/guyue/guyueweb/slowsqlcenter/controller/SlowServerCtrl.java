package com.guyue.guyueweb.slowsqlcenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.guyue.commonweb.BasePackage.ApiResult;
import com.guyue.commonweb.BasePackage.BaseController;
import com.guyue.guyueweb.mapperbean.TServerConfig;
import com.guyue.guyueweb.slowsqlcenter.service.SlowServerService;
@RestController
@RequestMapping("slowsqlcenter/serverconfig")
public class SlowServerCtrl extends BaseController{
	@Autowired
	private SlowServerService slowServerService;
	
	/**
	 * 获取所有的slow服务配置
	 * @return
	 */
	@RequestMapping(value="",method=RequestMethod.GET)
	public ApiResult listServerConfig(){
		List<TServerConfig> slowServers = slowServerService.selectServers();
		return ApiResult.success(slowServers);
	}
	/**
	 * 获取某一个slow服务器配置
	 * @param serverId
	 * @return
	 */
	@RequestMapping(value = "/{serverId}",method=RequestMethod.GET)
	public ApiResult getOneServerConfig(@PathVariable Integer serverId){
		TServerConfig slowServers = slowServerService.selectOneServers();
		return ApiResult.success(slowServers);
	}
	/**
	 * 新增一个slow服务器配置
	 * @param tServerConfig
	 * @return
	 */
	@RequestMapping(value = "{serverId}",method=RequestMethod.POST)
	public ApiResult addOneServerConfig(@RequestBody TServerConfig tServerConfig){
		return slowServerService.addServerConfig(tServerConfig);
	}
	/**
	 * 修改服务器配置
	 * @param tServerConfig
	 * @return
	 */
	@RequestMapping(value = "{serverId}",method=RequestMethod.PUT)
	public ApiResult modifyOneServerConfig(@RequestBody TServerConfig tServerConfig){
		return slowServerService.updateServerConfig(tServerConfig);
	}
	/**
	 * 修改服务器配置的最小时间
	 * @param serverId
	 * @param longQueryTime
	 * @return
	 */
	@RequestMapping(value = "{serverId}/{longQueryTime}/",method=RequestMethod.PUT)
	public ApiResult modifyServerConfigMinQuerytime(@PathVariable Integer serverId,@PathVariable Long longQueryTime){
		return slowServerService.updateServerConfigMinQuerytime(serverId,longQueryTime);
	}
}

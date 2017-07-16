package com.guyue.guyueweb.slowsqlcenter.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.guyue.commonweb.BasePackage.ApiResult;
import com.guyue.commonweb.BasePackage.BaseService;
import com.guyue.guyueweb.mapperbean.TServerConfig;
/**
 * slow服务器配置的Service
 * @author Administrator
 *
 */
@Service
public class SlowServerService extends BaseService {

	public List<TServerConfig> selectServers() {
		return null;
	}

	public TServerConfig selectOneServers() {
		return null;
	}

	public ApiResult addServerConfig(TServerConfig tServerConfig) {
		return null;
	}

	public ApiResult updateServerConfigMinQuerytime(Integer serverId,
			Long longQueryTime) {
		return null;
	}

	public ApiResult updateServerConfig(TServerConfig tServerConfig) {
		return null;
	}

}

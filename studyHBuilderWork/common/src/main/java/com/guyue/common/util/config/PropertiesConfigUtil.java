package com.guyue.common.util.config;

import java.util.Properties;

import com.guyue.common.util.FileUtil;

@SuppressWarnings("rawtypes")
public class PropertiesConfigUtil extends ConfigUtil{

	private String propertiesPath;
	PropertiesConfigUtil(String propertiesPath){
		this.propertiesPath=propertiesPath;
		initConfig();
	}
	@SuppressWarnings("unchecked")
	@Override
	void initConfig() {
		Properties readProperties = FileUtil.readProperties(propertiesPath);
		this.configMap.putAll(readProperties);
	}
}

package com.guyue.common.util.config;

import java.util.HashMap;
import java.util.Map;

public abstract class ConfigUtil<T> {
	Map<String,T> configMap = new HashMap<String, T>();
	public T getObject(String key){
		return configMap.get(key);
	}
	abstract void initConfig();
}

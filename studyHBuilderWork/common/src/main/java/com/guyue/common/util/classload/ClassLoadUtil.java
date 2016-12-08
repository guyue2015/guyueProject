package com.guyue.common.util.classload;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import org.slf4j.Logger;

import com.guyue.common.util.GuyueLoggerFactory;
import com.guyue.common.util.StringUtil;

public class ClassLoadUtil {
	private static Logger logger = GuyueLoggerFactory.getLogger(ClassLoadUtil.class);
	public static URLClassLoader loadClassByJarPath(String jarPath){
		if(StringUtil.isEmpty(jarPath)){
			logger.error("加载class失败,jar路径不能为空");
		}
		if(!jarPath.endsWith(".jar")){
			logger.error("加载class失败,jar后缀必须是.jar,给出的路径是：{}",jarPath);
		}
		URL jarUrl=null;
		try {
			jarUrl = new URL("file:"+jarPath);
		} catch (MalformedURLException e) {
			logger.error("URL异常",e);
		}
		URLClassLoader urlClassLoad = URLClassLoader.newInstance(new URL[]{jarUrl});
		return urlClassLoad;
	}
}

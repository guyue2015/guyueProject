package com.guyue.common.util.classload;

import java.lang.reflect.InvocationTargetException;
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
	public static void main(String[] args) {
		String classPath = "F:\\studyProjectWork\\studyHBuilderWork\\common\\target\\common-0.0.1-SNAPSHOT.jar";
		URL jarUrl=null;
		try {
			jarUrl = new URL("file:"+classPath);
		} catch (MalformedURLException e) {
			logger.error("URL异常",e);
		}
		URLClassLoader urlClassLoad = URLClassLoader.newInstance(new URL[]{jarUrl});
		try {
			Class classDateUtil = urlClassLoad.loadClass("TestJava");
			classDateUtil.getMethod("print").invoke(null);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

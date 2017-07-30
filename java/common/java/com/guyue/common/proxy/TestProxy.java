package com.guyue.common.proxy;

import java.lang.reflect.Proxy;

public class TestProxy {
	public static void main(String[] args) {
//		useProxy();
//		String str ="asd";
//		String object = (String)proxyAll(str);
//		System.out.println(object);
	}
	/**
	 *根据接口以及实现类，创建动态代理对象
	 */
	public static void useProxy(){
		String str = "Hello World";
		LoggingInvocationHandler logHandler = new LoggingInvocationHandler(str);
		ClassLoader cl = TestProxy.class.getClassLoader();
		Comparable obj = (Comparable) Proxy.newProxyInstance(cl, new Class[]{Comparable.class}, logHandler);
		System.out.println(obj);
		int a = obj.compareTo("Good");
		System.out.println(a);
				
	}
	public static Object proxyAll(final Object object){
		LoggingInvocationHandler logHandler = new LoggingInvocationHandler(object);
		ClassLoader cl = object.getClass().getClassLoader();
		Class<?>[] interfaces = object.getClass().getInterfaces();
		return Proxy.newProxyInstance(cl, interfaces, logHandler);
	}
}

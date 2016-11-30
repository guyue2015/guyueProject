package com.guyue.common.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LoggingInvocationHandler implements InvocationHandler
{
	private Object receiveObject;
	public LoggingInvocationHandler(Object object){
		this.receiveObject=object;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		return method.invoke(receiveObject, args);
	}

}

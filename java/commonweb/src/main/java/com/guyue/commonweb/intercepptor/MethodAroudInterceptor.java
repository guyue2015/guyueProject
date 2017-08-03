package com.guyue.commonweb.intercepptor;

import java.lang.reflect.Method;

import lombok.extern.slf4j.Slf4j;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;
@Component
@Slf4j
public class MethodAroudInterceptor implements MethodInterceptor{
    
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object[] params = invocation.getArguments();
        Method method = invocation.getMethod();
        String className = method.getDeclaringClass().toString();
        String methodName = method.getName();
        Long startTime = System.currentTimeMillis();
        Object result = invocation.proceed();
        Long takeTime = System.currentTimeMillis()-startTime;
        log.info("类名:{},方法:{}被调用，耗时:{}ms,参数:{}",className,methodName,takeTime,params);
        return result;
    }
}

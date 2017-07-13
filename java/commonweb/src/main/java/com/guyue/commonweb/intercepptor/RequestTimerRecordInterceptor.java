package com.guyue.commonweb.intercepptor;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.guyue.common.util.DateUtil;
import com.guyue.common.util.FileUtil;
import com.guyue.common.util.GuyueStringBuffer;
import com.guyue.common.util.StringUtil;

public class RequestTimerRecordInterceptor implements HandlerInterceptor {
	
	 private String requestTimeRecordPath;
	 
	public RequestTimerRecordInterceptor(String requestlogPath){
		 requestTimeRecordPath = requestlogPath;
	 }
	private Logger logger = LoggerFactory.getLogger(RequestTimerRecordInterceptor.class);
	
	private Long startTime;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		startTime = System.currentTimeMillis();
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		Long endTime = System.currentTimeMillis();
		if(StringUtil.isEmpty(requestTimeRecordPath)){
			requestTimeRecordPath = System.getProperty("java.io.tmpdir")+DateUtil.getCurrentDateString()+".log";
		}else if(!requestTimeRecordPath.endsWith(".log")){
			requestTimeRecordPath = requestTimeRecordPath+"/"+DateUtil.getCurrentDateString()+".log";
		}
		Path logFilePath = FileUtil.getPraseFileStrToPath(requestTimeRecordPath);
		String requestUrl = request.getRequestURI();
		GuyueStringBuffer requestRecordLog = new GuyueStringBuffer("请求访问的路径以及耗时:");
		requestRecordLog.append(requestUrl);
		requestRecordLog.append(",");
		requestRecordLog.appendln(String.valueOf(endTime-startTime));
		logger.info("接口访问时间记录在文件:{}",logFilePath);
		if(!logFilePath.toFile().exists()){
			Files.write(logFilePath, requestRecordLog.toString().getBytes(), StandardOpenOption.CREATE);
		}else{
			Files.write(logFilePath, requestRecordLog.toString().getBytes(), StandardOpenOption.APPEND);
		}
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}

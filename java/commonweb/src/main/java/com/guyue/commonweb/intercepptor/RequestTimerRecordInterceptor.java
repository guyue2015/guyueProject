package com.guyue.commonweb.intercepptor;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

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
		DateFormat df_ymd = new SimpleDateFormat("yyyy-MM-dd");
		 Calendar cal = Calendar.getInstance(TimeZone.getDefault());
	      String yyyyDDmm = df_ymd.format(cal.getTime());
		Long endTime = System.currentTimeMillis();
		if(StringUtils.isEmpty(requestTimeRecordPath)){
			requestTimeRecordPath = System.getProperty("java.io.tmpdir")+yyyyDDmm+".log";
		}else if(!requestTimeRecordPath.endsWith(".log")){
			requestTimeRecordPath = requestTimeRecordPath+"/"+yyyyDDmm+".log";
		}
		Path logFilePath = FileSystems.getDefault().getPath(requestTimeRecordPath);
		String requestUrl = request.getRequestURI();
		StringBuffer requestRecordLog = new StringBuffer("请求访问的路径以及耗时:");
		requestRecordLog.append(requestUrl);
		requestRecordLog.append(",");
		requestRecordLog.append(String.valueOf(endTime-startTime));
		requestRecordLog.append("\n");
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

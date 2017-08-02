package com.guyue.commonweb.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.guyue.commonweb.intercepptor.RequestRecordInterceptor;
import com.guyue.commonweb.intercepptor.RequestTimerRecordInterceptor;
@Configuration
public class GuyueWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {
	 @Value("${com.guyue.request.record.time.path:}")
	 private String name;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(new RequestTimerRecordInterceptor(name)).addPathPatterns("/**");
		super.addInterceptors(registry);
	}
}

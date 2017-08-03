package com.guyue.commonweb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.guyue.commonweb.intercepptor.ControllerRequestInterceptor;
@Configuration
public class GuyueWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new ControllerRequestInterceptor()).addPathPatterns("/**");
		super.addInterceptors(registry);
	}
}

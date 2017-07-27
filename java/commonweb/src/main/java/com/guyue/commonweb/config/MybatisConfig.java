package com.guyue.commonweb.config;


import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.guyue.commonweb.intercepptor.MybatisIntecepter;
import com.guyue.commonweb.config.GuyueWebCommonConfig;

@Configuration
public class MybatisConfig{
	
   @Bean
   public GuyueWebCommonConfig guyueWebCommonConfigBean(@Qualifier("sqlSessionFactoryBean") SqlSessionFactoryBean sqlSessionFactoryBean){
	   GuyueWebCommonConfig guyueWebBean = new GuyueWebCommonConfig();
//	   注册mybatis 插件
	   try {
		sqlSessionFactoryBean.getObject().getConfiguration().addInterceptor(new MybatisIntecepter());
	} catch (Exception e) {
		e.printStackTrace();
	}
		return guyueWebBean;
	}
}
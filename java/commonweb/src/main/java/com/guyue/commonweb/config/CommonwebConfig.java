package com.guyue.commonweb.config;


import lombok.extern.slf4j.Slf4j;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.aop.support.RegexpMethodPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import com.guyue.commonweb.intercepptor.MethodAroudInterceptor;
import com.guyue.commonweb.intercepptor.MybatisConnectionIntecepter;
import com.guyue.commonweb.intercepptor.MybatisSqlIntercepter;

@Configuration
@Slf4j
public class CommonwebConfig{
//	@Autowired
//	ConfigParam configParam;
//	
//	String recordPackagePath = configParam.getRecordPackagePath();
	@Value("${guyue.record.time.method.package:com.guyue.commonweb.empty.*}")
	private String recordPackagePath;
   /**
    * 增加数据源拦截器
     * @Title: guyueWebCommonConfigBean 
     * @Description: 
     * @param sqlSessionFactoryBean
     * @return
    */
   @Bean
   public GuyueWebCommonConfig guyueWebCommonConfigBean(@Qualifier("sqlSessionFactoryBean") SqlSessionFactoryBean sqlSessionFactoryBean){
	   GuyueWebCommonConfig guyueWebBean = new GuyueWebCommonConfig();
//	   注册mybatis 插件
	   try {
	       log.info("**************加载mybatisConnection拦截器****************");
		sqlSessionFactoryBean.getObject().getConfiguration().addInterceptor(new MybatisConnectionIntecepter());
		log.info("**************加载mybatissql拦截器****************");
		sqlSessionFactoryBean.getObject().getConfiguration().addInterceptor(new MybatisSqlIntercepter());
	} catch (Exception e) {
		e.printStackTrace();
	}
		return guyueWebBean;
	}
   /***
    * 增加方法运行拦截器
     * @Title: setMymethodpoInt 
     * @Description: 
     * @return
    */
   @Bean 
   public RegexpMethodPointcutAdvisor setMymethodpoInt(){
	   log.info("**************注册方法拦截器拦截包路径为:{}****************",recordPackagePath);
       RegexpMethodPointcutAdvisor methodPointAdvisor= new RegexpMethodPointcutAdvisor();
       methodPointAdvisor.setAdvice(new MethodAroudInterceptor());
       methodPointAdvisor.setPatterns(recordPackagePath);
       return methodPointAdvisor; 
   }
   
}

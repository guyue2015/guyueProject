package com.guyue.commonweb.config;


import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.aop.support.RegexpMethodPointcutAdvisor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.pagehelper.util.StringUtil;
import com.guyue.commonweb.intercepptor.MybatisIntecepter;
import com.guyue.commonweb.intercepptor.RequestRecordInterceptor;
import com.guyue.commonweb.config.GuyueWebCommonConfig;

@Configuration
public class MybatisConfig{
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
		sqlSessionFactoryBean.getObject().getConfiguration().addInterceptor(new MybatisIntecepter());
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
       RegexpMethodPointcutAdvisor methodPointAdvisor= new RegexpMethodPointcutAdvisor();
       methodPointAdvisor.setAdvice(new RequestRecordInterceptor());
       methodPointAdvisor.setPatterns(recordPackagePath);
       return methodPointAdvisor; 
   }
   
}

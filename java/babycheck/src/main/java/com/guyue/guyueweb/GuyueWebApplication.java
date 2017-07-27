package com.guyue.guyueweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration(exclude={    
	      JpaRepositoriesAutoConfiguration.class//禁止springboot自动加载持久化bean  
	        })
public class GuyueWebApplication{
	
	public static void main(String[] args) {
		SpringApplication.run(GuyueWebApplication.class, args);
	}
}
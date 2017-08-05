package com.guyue.guyueweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.guyue.commonweb","com.guyue.guyueweb"})
public class GuyueWebApplication{
	
	public static void main(String[] args) {
		SpringApplication.run(GuyueWebApplication.class, args);
	}
}
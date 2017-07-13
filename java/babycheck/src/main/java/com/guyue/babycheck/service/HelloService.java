package com.guyue.babycheck.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
	
	 @Value("${com.guyue.request.record.time.path}")
	 private String name;
	 
	 public void print(){
		 System.out.println("############"+name);
	 }
}

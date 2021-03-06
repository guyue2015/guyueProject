package com.guyue.guyueweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guyue.guyueweb.service.HelloService;

@RestController
public class HelloController {
	@Autowired
	 private HelloService helloService;
	@RequestMapping("/test")
	String index() {
		helloService.print();
		return "Hello World!";
	}
}

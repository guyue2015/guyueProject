package com.guyue.apispeed.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guyue.common.service.CommonConfigService;
import com.guyue.common.vo.CommonOptLog;

@Controller
@RequestMapping("/test")
public class TestProjectController extends ApiSpeedBaseController{
	@Autowired
	private CommonConfigService commonConfigService;
	@RequestMapping(value="/getName",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,String> getProjectName(){
		Map<String,String> resultMap = new HashMap<String, String>();
		resultMap.put("method", "getName");
		CommonOptLog record = new CommonOptLog();
		record.setOperatorId(12);
		record.setOperateModel(10);
		record.setOperatorName("test");
		record.setKeyId(12);
		record.setCreateTime(new Date());
		record.setIp("192.168.15.75");
		record.setAction(5);
		record.setMessage("asdad");
		record.setSource(true);
		record.setSuccessStatus(true);
		commonConfigService.insert(record);
		return resultMap;
	}
	/**
	 * 登录
	 * @authro rainyhao
	 * @since 2016-4-12 上午8:52:28
	 * @param username 登录名
	 * @param pwd 密码
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> login(@RequestBody Map<String,String> model) {
		String loginName = model.get("loginName");
		String password = model.get("password");
		UsernamePasswordToken token = new UsernamePasswordToken(loginName, password);
		Subject subject = SecurityUtils.getSubject();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			subject.login(token);
			map.put("code", "200");
		} catch (Exception e) {
			map.put("code", "400");
			map.put("exception", e.getMessage());
		}
		return map;
	}
	
	/**
	 * 登录
	 * @authro rainyhao
	 * @since 2016-4-12 上午8:52:28
	 * @param username 登录名
	 * @param pwd 密码
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> search() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String,String>> data = new ArrayList<Map<String,String>>();
		for(int i=0;i<3;i++){
			Map<String,String> tempMap = new HashMap<String, String>();
			tempMap.put("test1", "key"+i);
			tempMap.put("test2", "www"+i);
			tempMap.put("test3", "ddd"+i);
			tempMap.put("test4", "ffff"+i);
			data.add(tempMap);
		}
		map.put("code", "200");
		map.put("data", data);
		return map;
	}
}

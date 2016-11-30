package com.guyue.apispeed.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guyue.common.controller.CommonBaseController;

@Controller
@RequestMapping("/test")
public class TestProjectController extends CommonBaseController{
	@RequestMapping(value="/getName",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,String> getProjectName(){
		Map<String,String> resultMap = new HashMap<String, String>();
		resultMap.put("method", "getName");
		return resultMap;
	}
}

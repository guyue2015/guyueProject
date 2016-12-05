package com.guyue.apispeed.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guyue.common.controller.CommonBaseController;
import com.guyue.common.service.CommonConfigService;
import com.guyue.common.vo.CommonOptLog;

@Controller
@RequestMapping("/test")
public class TestProjectController extends CommonBaseController{
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
}

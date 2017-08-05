package com.guyue.guyueweb.babycheck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.guyue.commonweb.BasePackage.ApiResult;
import com.guyue.guyueweb.babycheck.service.BabyCheckService;
import com.guyue.guyueweb.babycheck.vo.BabyCheckVo;

@RestController
@RequestMapping("babycheck/check")
public class BabycheckContrller {
	@Autowired
	private BabyCheckService babyCheckService;
	@RequestMapping(value="getHtppResult",method=RequestMethod.POST)
	public ApiResult check(@RequestBody BabyCheckVo babyCheckVo){
		return babyCheckService.checkDoding(babyCheckVo);
	}
}

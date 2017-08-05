package com.guyue.guyueweb.babycheck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.guyue.commonweb.BasePackage.ApiResult;
import com.guyue.guyueweb.babycheck.service.TCityService;
import com.guyue.guyueweb.mapperbean.TBabyCheckCity;

@RestController
@RequestMapping("babycheck/tCity")
public class TCityController {
	@Autowired
	private TCityService tCityService;
	
	@RequestMapping(value="",method = RequestMethod.GET)
	public ApiResult listTCity(TBabyCheckCity tCity){
		return tCityService.listTCity(tCity);
	}
	@RequestMapping(value="",method = RequestMethod.POST)
	public ApiResult saveTCity(@RequestBody TBabyCheckCity tCity){
		return tCityService.saveTCity(tCity);
	}
	@RequestMapping(value="",method = RequestMethod.PUT)
	public ApiResult updateTCity(@RequestBody TBabyCheckCity tCity){
		return tCityService.updateTCity(tCity);
	}
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public ApiResult getTCity(@PathVariable Integer id){
		return tCityService.getTCity(id);
	}
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public ApiResult delTCity(@PathVariable Long id){
		return tCityService.deleteTCity(id);
	}
}

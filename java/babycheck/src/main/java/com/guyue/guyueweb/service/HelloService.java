package com.guyue.guyueweb.service;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guyue.guyueweb.mapper.TBabyCheckCityMapper;
import com.guyue.guyueweb.mapperbean.TBabyCheckCity;

@Service
@Slf4j
public class HelloService {
	
	@Autowired
	private TBabyCheckCityMapper tBabyCheckCityMapper;
	
	 public void print(){
		 List<TBabyCheckCity> selectAll = tBabyCheckCityMapper.selectAll();
		 log.info("测试数据库查询：结果为：{}",selectAll.size());
	 }
}

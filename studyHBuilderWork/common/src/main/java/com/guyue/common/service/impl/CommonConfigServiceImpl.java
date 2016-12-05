package com.guyue.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guyue.common.dao.CommonOptLogMapper;
import com.guyue.common.service.CommonBaseService;
import com.guyue.common.service.CommonConfigService;
import com.guyue.common.vo.CommonOptLog;

@Service
public class CommonConfigServiceImpl extends CommonBaseService implements CommonConfigService{

	@Autowired
	private CommonOptLogMapper commonOptLogMapper;
	@Override
	public int insert(CommonOptLog record) {
		return commonOptLogMapper.insert(record);
	}
}

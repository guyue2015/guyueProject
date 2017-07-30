package com.guyue.guyueweb.babycheck.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guyue.commonweb.BasePackage.ApiResult;
import com.guyue.guyueweb.mapper.TBabyCheckCityMapper;
import com.guyue.guyueweb.mapperbean.TBabyCheckCity;

@Service
public class TCityService extends BabyCommonService{

	@Autowired
	private TBabyCheckCityMapper tBabyCheckCityMapper;
	
	/**
	 * 查询所有的设置的城市列表
	 * @param tCity 查询条件
	 * @return
	 */
	public ApiResult listTCity(TBabyCheckCity tCity) {
		List<TBabyCheckCity> tCityList = tBabyCheckCityMapper.select(tCity);
		return ApiResult.success(tCityList);
	}

	/**
	 * 新增城市
	 * @param tCity
	 * @return
	 */
	public ApiResult saveTCity(TBabyCheckCity tCity) {
		Integer result = tBabyCheckCityMapper.insert(tCity);
		if(result>1){
			return ApiResult.success();
		}
		return ApiResult.invalid("插入城市失败");
	}
	
	/**
	 * 修改城市属性
	 * @param id
	 * @param tCity
	 * @return
	 */
    public ApiResult updateTCity(TBabyCheckCity tCity) {
		tBabyCheckCityMapper.updateByPrimaryKeySelective(tCity);
		return ApiResult.success();
	}

    /**
     * 查询城市详情
     * @param id
     * @return
     */
	public ApiResult getTCity(Integer id) {
		TBabyCheckCity tCity = tBabyCheckCityMapper.selectByPrimaryKey(id);
		if(tCity!=null){
			return ApiResult.success(tCity);
		}else{
			return ApiResult.invalid("没有对应的数据");
		}
	}
	
}

package com.guyue.common.dao;

import com.guyue.common.vo.CommonProjectuser;

public interface CommonProjectuserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CommonProjectuser record);

    int insertSelective(CommonProjectuser record);

    CommonProjectuser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CommonProjectuser record);

    int updateByPrimaryKey(CommonProjectuser record);
}
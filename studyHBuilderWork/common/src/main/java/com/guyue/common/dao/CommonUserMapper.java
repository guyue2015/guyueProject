package com.guyue.common.dao;

import com.guyue.common.vo.CommonUser;

public interface CommonUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CommonUser record);

    int insertSelective(CommonUser record);

    CommonUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CommonUser record);

    int updateByPrimaryKey(CommonUser record);
}
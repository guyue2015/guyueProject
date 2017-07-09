package com.guyue.common.dao;

import com.guyue.common.vo.CommonUserright;

public interface CommonUserrightMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CommonUserright record);

    int insertSelective(CommonUserright record);

    CommonUserright selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CommonUserright record);

    int updateByPrimaryKey(CommonUserright record);
}
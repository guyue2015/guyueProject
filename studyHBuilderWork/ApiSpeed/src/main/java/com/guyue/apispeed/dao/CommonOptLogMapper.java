package com.guyue.apispeed.dao;

import com.guyue.apispeed.vo.CommonOptLog;

public interface CommonOptLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CommonOptLog record);

    int insertSelective(CommonOptLog record);

    CommonOptLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommonOptLog record);

    int updateByPrimaryKey(CommonOptLog record);
}
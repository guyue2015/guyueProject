package com.guyue.common.dao;

import com.guyue.common.vo.CommonOptLog;

public interface CommonOptLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CommonOptLog record);

    int insertSelective(CommonOptLog record);

    CommonOptLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommonOptLog record);

    int updateByPrimaryKey(CommonOptLog record);
}
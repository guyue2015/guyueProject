package com.guyue.common.dao;

import com.guyue.common.vo.CommonCode;

public interface CommonCodeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CommonCode record);

    int insertSelective(CommonCode record);

    CommonCode selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CommonCode record);

    int updateByPrimaryKey(CommonCode record);
}
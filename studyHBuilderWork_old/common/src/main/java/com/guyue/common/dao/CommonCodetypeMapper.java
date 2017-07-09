package com.guyue.common.dao;

import com.guyue.common.vo.CommonCodetype;

public interface CommonCodetypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CommonCodetype record);

    int insertSelective(CommonCodetype record);

    CommonCodetype selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CommonCodetype record);

    int updateByPrimaryKey(CommonCodetype record);
}
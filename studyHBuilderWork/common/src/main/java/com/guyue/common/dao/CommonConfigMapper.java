package com.guyue.common.dao;

import com.guyue.common.vo.CommonConfig;

public interface CommonConfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CommonConfig record);

    int insertSelective(CommonConfig record);

    CommonConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommonConfig record);

    int updateByPrimaryKey(CommonConfig record);
}
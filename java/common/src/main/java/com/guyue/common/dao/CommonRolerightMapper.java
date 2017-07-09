package com.guyue.common.dao;

import com.guyue.common.vo.CommonRoleright;

public interface CommonRolerightMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CommonRoleright record);

    int insertSelective(CommonRoleright record);

    CommonRoleright selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CommonRoleright record);

    int updateByPrimaryKey(CommonRoleright record);
}
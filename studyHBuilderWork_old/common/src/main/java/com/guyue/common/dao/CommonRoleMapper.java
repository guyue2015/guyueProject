package com.guyue.common.dao;

import com.guyue.common.vo.CommonRole;

public interface CommonRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CommonRole record);

    int insertSelective(CommonRole record);

    CommonRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CommonRole record);

    int updateByPrimaryKey(CommonRole record);
}
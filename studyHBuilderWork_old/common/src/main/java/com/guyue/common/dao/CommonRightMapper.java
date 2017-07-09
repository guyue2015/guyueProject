package com.guyue.common.dao;

import com.guyue.common.vo.CommonRight;

public interface CommonRightMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CommonRight record);

    int insertSelective(CommonRight record);

    CommonRight selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CommonRight record);

    int updateByPrimaryKey(CommonRight record);
}
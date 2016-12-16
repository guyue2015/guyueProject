package com.guyue.common.dao;

import com.guyue.common.vo.CommonMode;

public interface CommonModeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CommonMode record);

    int insertSelective(CommonMode record);

    CommonMode selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CommonMode record);

    int updateByPrimaryKey(CommonMode record);
}
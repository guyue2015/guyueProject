package com.guyue.common.dao;

import com.guyue.common.vo.CommonProject;

public interface CommonProjectMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CommonProject record);

    int insertSelective(CommonProject record);

    CommonProject selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CommonProject record);

    int updateByPrimaryKey(CommonProject record);
}
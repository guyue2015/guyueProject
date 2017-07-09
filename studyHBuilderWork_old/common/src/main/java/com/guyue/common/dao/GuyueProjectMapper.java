package com.guyue.common.dao;

import com.guyue.common.vo.GuyueProject;

public interface GuyueProjectMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GuyueProject record);

    int insertSelective(GuyueProject record);

    GuyueProject selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GuyueProject record);

    int updateByPrimaryKey(GuyueProject record);
}
package com.guyue.apispeed.dao;

import com.guyue.apispeed.vo.ProjectParams;

public interface ProjectParamsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProjectParams record);

    int insertSelective(ProjectParams record);

    ProjectParams selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProjectParams record);

    int updateByPrimaryKey(ProjectParams record);
}
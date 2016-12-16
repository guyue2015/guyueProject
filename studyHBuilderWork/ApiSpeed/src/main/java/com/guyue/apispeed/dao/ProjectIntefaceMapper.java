package com.guyue.apispeed.dao;

import com.guyue.apispeed.vo.ProjectInteface;

public interface ProjectIntefaceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProjectInteface record);

    int insertSelective(ProjectInteface record);

    ProjectInteface selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProjectInteface record);

    int updateByPrimaryKey(ProjectInteface record);
}
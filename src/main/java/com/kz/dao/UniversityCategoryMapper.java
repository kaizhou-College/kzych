package com.kz.dao;

import com.kz.po.UniversityCategory;

public interface UniversityCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UniversityCategory record);

    int insertSelective(UniversityCategory record);

    UniversityCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UniversityCategory record);

    int updateByPrimaryKey(UniversityCategory record);
}
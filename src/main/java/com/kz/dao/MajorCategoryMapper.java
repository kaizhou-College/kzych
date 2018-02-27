package com.kz.dao;

import com.kz.po.MajorCategory;

public interface MajorCategoryMapper {
    int deleteByPrimaryKey(Long majorCategoryId);

    int insert(MajorCategory record);

    int insertSelective(MajorCategory record);

    MajorCategory selectByPrimaryKey(Long majorCategoryId);

    int updateByPrimaryKeySelective(MajorCategory record);

    int updateByPrimaryKey(MajorCategory record);
}
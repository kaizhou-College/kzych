package com.kz.dao;

import com.kz.po.PackageCategory;

public interface PackageCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PackageCategory record);

    int insertSelective(PackageCategory record);

    PackageCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PackageCategory record);

    int updateByPrimaryKeyWithBLOBs(PackageCategory record);

    int updateByPrimaryKey(PackageCategory record);
}
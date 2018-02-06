package com.kz.dao;

import com.kz.po.Package;

public interface PackageMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Package record);

    int insertSelective(Package record);

    Package selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Package record);

    int updateByPrimaryKey(Package record);
}
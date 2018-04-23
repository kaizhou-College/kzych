package com.kz.dao;


import com.kz.core.dao.BaseMapper;
import com.kz.po.MajorCategory;
import com.kz.po.MajorCategoryQuery;

public interface MajorCategoryMapper extends BaseMapper<MajorCategory, MajorCategoryQuery>{
    int deleteByPrimaryKey(Long majorCategoryId);

    Long insert(MajorCategory record);
    
    Long insertSelective(MajorCategory record);
    
    MajorCategory selectByPrimaryKey(Long majorCategoryId);
    
    Long updateByPrimaryKeySelective(MajorCategory record);
    
    Long updateByPrimaryKey(long l);
    
    
    
}

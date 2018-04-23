package com.kz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kz.core.dao.BaseMapper;
import com.kz.po.Major;
import com.kz.po.MajorCategory;
import com.kz.po.MajorQuery;
import com.kz.po.MajorUniversity;

public interface MajorMapper extends BaseMapper<Major, MajorQuery>{
	MajorUniversity findByUniversityId(@Param("universityId")int universityId, @Param("majorId")int majorId);
	
}
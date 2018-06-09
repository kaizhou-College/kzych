package com.kz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.alipay.api.domain.Image;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Joiner.MapJoiner;
import com.kz.core.dao.BaseMapper;
import com.kz.po.Major;
import com.kz.po.MajorCategory;
import com.kz.po.MajorCategoryQuery;
import com.kz.po.MajorQuery;
import com.kz.po.MajorUniversity;
import com.kz.po.SearchModel;
import com.kz.po.University;

public interface MajorMapper extends BaseMapper<Major, MajorQuery>{
	MajorUniversity findByUniversityId(@Param("universityId")int universityId, @Param("majorId")int majorId);

	List<Major> myMajorHot(Integer isHot);

	List<SearchModel> majorByNameDim(MajorQuery qm);
	
}
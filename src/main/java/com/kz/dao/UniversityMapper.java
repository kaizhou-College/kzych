package com.kz.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.github.pagehelper.PageInfo;
import com.kz.core.dao.BaseMapper;
import com.kz.po.University;
import com.kz.po.UniversityQuery;

@Repository
public interface UniversityMapper extends BaseMapper<University, UniversityQuery>{
	
	List<University> selectMajorsPageById(Long id);
	List<University> listKeyPublishStatus(UniversityQuery uq);
	Long insertSelectiveSequence(University m);
	Long updateByKeySelective(University m);
	List<University> schoolByUserIdList(University m);
	Long schoolByUserIdUpdate(University m);
	List<University> schoolByIsNotHotList(Integer isHot);
	List<University> selectByPrimaryLongitudeAndLatitude(UniversityQuery uq);
	List<University> selectByMajorCategoryId(UniversityQuery uq);
}
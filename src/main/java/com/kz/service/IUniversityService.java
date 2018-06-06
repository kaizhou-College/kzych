package com.kz.service;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kz.core.common.ServerResponse;
import com.kz.core.service.IBaseService;
import com.kz.po.Address;
import com.kz.po.Major;
import com.kz.po.RecruitStudents;
import com.kz.po.University;
import com.kz.po.UniversityQuery;
import com.kz.po.User;
import com.kz.po.UserQuery;

public interface IUniversityService extends IBaseService<University, UniversityQuery>{

	List<University> selectMajorsPageById(UniversityQuery qu);
	PageInfo listKeyPublishStatus(UniversityQuery qu);
	List categoryList(); 
	Long insertSelectiveSequence(University m);
	Long updateByKeySelective(University m);
	List<University> schoolByUserIdList(University m);
	Long schoolByUserIdUpdate(University qu);
	PageInfo<University> schoolByIsNotHotList(UniversityQuery hq);
	PageInfo<University> schoolAddressList(UniversityQuery hq);
	PageInfo<University> selectByMajorCategoryId(UniversityQuery qu);
	Long updateByTelephone(University u);
	List<RecruitStudents> selectByUniversityId(int universityId);
	PageInfo selectByMajorId(UniversityQuery qu);
	PageInfo schoolByIntroduceInfo(UniversityQuery u);
	PageInfo schollByTypeList(UniversityQuery qu);
	PageInfo schollAndAddressList(UniversityQuery qu);
	PageInfo schollByMajor(UniversityQuery qu);
	PageInfo schollByIntroduce(UniversityQuery qu);
	PageInfo schollByRecruit(UniversityQuery qu);
	Long prodectAdd(University m,Address address);
	Long prodectUpdate(UniversityQuery qu);
	Long userInfoSchool(UniversityQuery qu);
	List<University> mySchoolMajorInfo(UniversityQuery qu);
}

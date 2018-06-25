package com.kz.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.github.pagehelper.PageInfo;
import com.kz.core.dao.BaseMapper;
import com.kz.po.Introduce;
import com.kz.po.Major;
import com.kz.po.MajorQuery;
import com.kz.po.SearchModel;
import com.kz.po.University;
import com.kz.po.UniversityDynamic;
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
	Long updateByTelephone(University u);
	List selectByUniversityId(int universityId);
	List<University> selectByMajorId(UniversityQuery qu);
	List<University> schoolByIntroduceInfo(UniversityQuery qu);
	List<University> schollByTypeList(UniversityQuery qu);
	List<University> schollAndAddressList(Long universityId);
	List<Major> schollByMajor(Long universityId);
	List<Introduce> schollByIntroduce(Long universityId);
	List<UniversityDynamic> schollByRecruit(Long universityId);
	List<University> mySchoolMajorInfo(Long universityId);
	University UniversityCostDetail(UniversityQuery qu);
	List<University> myUniversityHost(UniversityQuery qu);
	List<SearchModel> universityByNameDim(MajorQuery qm);
	List<University> schoolByUserIdListNoAddress(University m);
}
package com.kz.service.impl;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kz.core.service.BaseService;
import com.kz.dao.AddressMapper;
import com.kz.dao.UniversityCategoryMapper;
import com.kz.dao.UniversityMapper;
import com.kz.po.Address;
import com.kz.po.Introduce;
import com.kz.po.Major;
import com.kz.po.University;
import com.kz.po.UniversityDynamic;
import com.kz.po.UniversityQuery;
import com.kz.service.IUniversityService;

@Service
@Transactional
public class UniversityServiceImpl extends BaseService<University, UniversityQuery> implements IUniversityService {
	private UniversityMapper mapper;
	@Autowired
	public void setMapper(UniversityMapper mapper){
		this.mapper = mapper;
		super.setMapper(mapper);
	}
	@Autowired
	private UniversityCategoryMapper mapperC;
	@Autowired
	private AddressMapper mapperA;
	
	public List<University> selectMajorsPageById(UniversityQuery qu) {
		List<University> result =null;
		PageHelper.startPage(qu.getPageNum(),qu.getPageSize());
		result = mapper.selectMajorsPageById(qu.getUniversityId());
		return result;
		
	}
	@Override
	public PageInfo<University> listKeyPublishStatus(UniversityQuery qu) {
			PageHelper.startPage(qu.getPageNum(),qu.getPageSize());
			List<University> list = mapper.listKeyPublishStatus(qu);
			PageInfo<University> result = new PageInfo<University>(list);
			return result;
	}
	/*
	 * public PageInfo<M> getByConditionPage(QM qm) {
		PageHelper.startPage(qm.getPageNum(),qm.getPageSize());
		List<M> list = mapper.getByConditionPage(qm);
		for(M m :list){
			System.out.println(m);
		}
		PageInfo<M> result = new PageInfo<M>(list);
		return result;
	}
	 * */
	@Override
	public List categoryList() {
		return mapperC.select();
	}
	@Override
	public Long insertSelectiveSequence(University m) {
		m.setCode(1L);
		m.setEmploymentInfo("暂时未设值");
		m.setBrochure("暂时未设值");
		m.setAgreements("暂时未设值");
		m.setTelephone("暂时未设值");
		m.setGrants(new BigDecimal("11.0"));
		m.setCoupon(new BigDecimal("11.0"));
		//设置申请开通学校状态  刚刚申请都是1（开通中）
		m.setPublishStatus(1);
		return mapper.insertSelectiveSequence(m);
	}
	
	@Override
	public Long updateByKeySelective(University m) {
		return mapper.updateByKeySelective(m);
	}
	@Override
	public List<University> schoolByUserIdList(University m) {
		List<University> result= mapper.schoolByUserIdList(m);
		return  result;
	}
	@Override
	public Long schoolByUserIdUpdate(University m) {
		return mapper.schoolByUserIdUpdate(m);
	}
	@Override
	public PageInfo<University> schoolByIsNotHotList(UniversityQuery hq) {
		PageHelper.startPage(hq.getPageNum(),hq.getPageSize());
		List<University> list = mapper.schoolByIsNotHotList(hq.getIsHot());
		PageInfo<University> result = new PageInfo<University>(list);
		return result;
	}
	@Override
	public PageInfo<University> schoolAddressList(UniversityQuery uq) {
		PageHelper.startPage(uq.getPageNum(),uq.getPageSize());
		List<University> list = mapper.selectByPrimaryLongitudeAndLatitude(uq);
		PageInfo<University> result = new PageInfo<University>(list);
		return result;
	}
	@Override
	public PageInfo<University> selectByMajorCategoryId(UniversityQuery qu) {
		PageHelper.startPage(qu.getPageNum(),qu.getPageSize());
		List<University> list = mapper.selectByMajorCategoryId(qu);
		PageInfo<University> result = new PageInfo<University>(list);
		return result;
	}
	@Override
	public Long updateByTelephone(University u) {
		Long updateByTelephone = mapper.updateByTelephone(u);
		return updateByTelephone;
	}
	@Override
	public List<UniversityDynamic> selectByUniversityId(int universityId) {
		List list = mapper.selectByUniversityId(universityId);
		return list;
	}
	@Override
	public PageInfo selectByMajorId(UniversityQuery qu) {
		PageHelper.startPage(qu.getPageNum(),qu.getPageSize());
		List<University> list = mapper.selectByMajorId(qu);
		PageInfo<University> result = new PageInfo<University>(list);
		return result;
	}
	@Override
	public PageInfo schoolByIntroduceInfo(UniversityQuery u) {
		List<University> info = mapper.schoolByIntroduceInfo(u);
		PageInfo<University> result = new PageInfo<University>(info);
		return result;
	}
	@Override
	public PageInfo schollByTypeList(UniversityQuery qu) {
		PageHelper.startPage(qu.getPageNum(),qu.getPageSize());
		List<University> list =mapper.schollByTypeList(qu);
		PageInfo<University> result = new PageInfo<University>(list);
		return result;
	}
	@Override
	public PageInfo universityDetail(UniversityQuery qu) {
		List<University> result =null;
		if(qu.getCurrentNum()==0){
			result=mapper.schollAndAddressList(qu.getUniversityId());
			PageHelper.startPage(qu.getPageNum(),qu.getPageSize());
			List<Major> resultMajor=mapper.schollByMajor(qu.getUniversityId());
			if(resultMajor.size()>=0)
				result.get(0).setMajors(resultMajor);
		}else if(qu.getCurrentNum()==1){
			result=mapper.schollAndAddressList(qu.getUniversityId());
			List<Introduce> resultIntroduce =mapper.schollByIntroduce(qu.getUniversityId());
			if(resultIntroduce.size()>=1)
				result.get(0).setIntroduce(resultIntroduce.get(0));
		}else if(qu.getCurrentNum()==2){
			result=mapper.schollAndAddressList(qu.getUniversityId());
			List<UniversityDynamic> resultRecruit =mapper.schollByRecruit(qu.getUniversityId());
			if(resultRecruit.size()>=1)
				result.get(0).setUniversityDynamic(resultRecruit);
		}
		PageInfo<University> pageInfo = new PageInfo<University>(result);
		return pageInfo;
	}
	@Override
	public PageInfo schollByMajor(UniversityQuery qu) {
		PageHelper.startPage(qu.getPageNum(),qu.getPageSize());
		List<Major> list =mapper.schollByMajor(qu.getUniversityId());
		PageInfo<Major> result = new PageInfo<Major>(list);
		return result;
	}
	@Override
	public PageInfo schollByIntroduce(UniversityQuery qu) {
		List<Introduce> list =mapper.schollByIntroduce(qu.getUniversityId());
		PageInfo<Introduce> result = new PageInfo<Introduce>(list);
		return result;
	}
	
	@Override
	public PageInfo schollByRecruit(UniversityQuery qu) {
		List<UniversityDynamic> list =mapper.schollByRecruit(qu.getUniversityId());
		PageInfo<UniversityDynamic> result = new PageInfo<UniversityDynamic>(list);
		return result;
	}
	@Override
	public Long prodectAdd(University m,Address address){
		Long long1=insertSelective(m);
		Long long2=0L;
		List<University> list = null;
		if(long1==1L){//成功
			//查询该用户的学校id
			list = mapper.schoolByUserIdListNoAddress(m);
			address.setUniversityId(list.get(0).getId());
			long2 = mapperA.insertSelective(address);
		}
		return long2+long1;
	}
	@Override
	public Long prodectUpdate(UniversityQuery qu) {
		Long long1 = mapper.schoolByUserIdUpdate(qu.getUniversity());
		Long long2 = mapperA.updateByPrimaryKeySelective(qu.getAddress());
		return long1+long2;
	}
	@Override
	public Long userInfoSchool(UniversityQuery qu) {
		Long long1 = mapper.schoolByUserIdUpdate(qu.getUniversity());
		qu.getAddress().setProvice(qu.getProvice());
		qu.getAddress().setCity(qu.getCity());
		qu.getAddress().setCounty(qu.getCounty());
		Long long2 = mapperA.updateByPrimaryKeySelective(qu.getAddress());
		return long1+long2;
	}
	@Override
	public List<University> mySchoolMajorInfo(UniversityQuery qu) {
		List<University> schoolResult = mapper.mySchoolMajorInfo(qu.getUniversityId());
		return schoolResult;
	}
	@Override
	public PageInfo<University> myUniversityHost(UniversityQuery qu) {
		PageHelper.startPage(qu.getPageNum(),qu.getPageSize());
		List<University> universityList=mapper.myUniversityHost(qu);
		PageInfo<University> result = new PageInfo<University>(universityList);
		return result;
	}
	
}

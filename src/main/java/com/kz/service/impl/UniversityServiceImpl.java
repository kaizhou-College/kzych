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
import com.kz.dao.UniversityCategoryMapper;
import com.kz.dao.UniversityMapper;
import com.kz.po.RecruitStudents;
import com.kz.po.University;
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
	public List<University> selectMajorsPageById(Long id,int pageNum,int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return mapper.selectMajorsPageById(id);
		
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
		m.setProfile("暂时未设值");
		m.setCode(1L);
		m.setProfile("暂时未设值");
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
	public List<RecruitStudents> selectByUniversityId(int universityId) {
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
	public PageInfo schollAndAddressList(UniversityQuery qu) {
		List<University> list =mapper.schollAndAddressList(qu.getUniversityId());
		PageInfo<University> result = new PageInfo<University>(list);
		return result;
	}
	@Override
	public PageInfo schollByMajor(UniversityQuery qu) {
		List<University> list =mapper.schollByMajor(qu.getUniversityId());
		PageInfo<University> result = new PageInfo<University>(list);
		return result;
	}
	@Override
	public PageInfo schollByIntroduce(UniversityQuery qu) {
		List<University> list =mapper.schollByIntroduce(qu.getUniversityId());
		PageInfo<University> result = new PageInfo<University>(list);
		return result;
	}
	
	@Override
	public PageInfo schollByRecruit(UniversityQuery qu) {
		List<University> list =mapper.schollByRecruit(qu.getUniversityId());
		PageInfo<University> result = new PageInfo<University>(list);
		return result;
	}
	
}

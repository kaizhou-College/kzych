package com.kz.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.kz.core.service.BaseService;
import com.kz.dao.UniversityMapper;
import com.kz.po.Major;
import com.kz.po.University;
import com.kz.po.UniversityQuery;
import com.kz.vo.UniversityListVo;

@Service
public class UniversityServiceImpl extends BaseService<University, UniversityQuery> implements IUniversityService {
	private UniversityMapper mapper;
	@Autowired
	public void setMapper(UniversityMapper mapper){
		this.mapper = mapper;
		super.setMapper(mapper);
	}
	
	public PageInfo<University> getByConditionPage(UniversityQuery uq) {
		PageHelper.startPage(uq.getPageNum(),uq.getPageSize());
		List<University> universityList = mapper.getByConditionPage(uq);
		
		List<UniversityListVo> universityListVoList = Lists.newArrayList();
		
		for(University university:universityList){
			UniversityListVo universityListVo = new UniversityListVo();
			BeanUtils.copyProperties(university, universityListVo);
			universityListVoList.add(universityListVo);
		}
		PageInfo result = new PageInfo(universityList);
		result.setList(universityListVoList);
		return result;
	}

	@Override
	public University selectMajorsPageById(Long id,int pageNum,int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return mapper.selectMajorsPageById(id);
		
	}
}

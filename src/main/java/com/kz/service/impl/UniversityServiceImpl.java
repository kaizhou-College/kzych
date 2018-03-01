package com.kz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.kz.core.service.BaseService;
import com.kz.dao.UniversityMapper;
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
	public University selectMajorsPageById(Long id,int pageNum,int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return mapper.selectMajorsPageById(id);
		
	}
}

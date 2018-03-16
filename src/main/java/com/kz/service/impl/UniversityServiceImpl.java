package com.kz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
	@Override
	public PageInfo<University> listKeyPublishStatus(UniversityQuery qu) {
			PageHelper.startPage(qu.getPageNum(),qu.getPageSize());
			List<University> list = mapper.listKeyPublishStatus(qu);
			PageInfo<University> result = new PageInfo<University>(list);
			return result;
	}
}

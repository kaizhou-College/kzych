package com.kz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kz.core.service.BaseService;
import com.kz.dao.MajorCategoryMapper;
import com.kz.dao.MajorMapper;
import com.kz.po.Major;
import com.kz.po.MajorCategory;
import com.kz.po.MajorCategoryQuery;
import com.kz.po.MajorQuery;
import com.kz.po.MajorUniversity;
import com.kz.service.IMajorService;

@Service
@Transactional
public class MajorServiceImpl extends BaseService<Major, MajorQuery> implements IMajorService {
	
	private MajorMapper mapper;
	
	@Autowired
	public void setMapper(MajorMapper mapper) {
		this.mapper =mapper;
		super.setMapper(mapper);
	}
	@Override
	public MajorUniversity findByUniversityId(int universityId, int majorId) {
		return mapper.findByUniversityId(universityId,majorId);
	}
	@Autowired
	private MajorCategoryMapper mapperMC;
	
	@Override
	public PageInfo<MajorCategory> majorCategorylist(MajorCategoryQuery qm) {
		PageHelper.startPage(qm.getPageNum(),qm.getPageSize());
		List<MajorCategory> list=mapperMC.getByConditionPage(qm);
		PageInfo<MajorCategory> result = new PageInfo<MajorCategory>(list);
		return result;
	}
}

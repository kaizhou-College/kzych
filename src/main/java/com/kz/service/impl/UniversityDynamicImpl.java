package com.kz.service.impl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kz.core.service.BaseService;
import com.kz.dao.UniversityDynamicMapper;
import com.kz.po.UniversityDynamic;
import com.kz.po.UniversityDynamicQuery;
import com.kz.service.IUniversityDynamic;
@Service
@Transactional
public class UniversityDynamicImpl extends BaseService<UniversityDynamic, UniversityDynamicQuery> implements IUniversityDynamic  {
	private UniversityDynamicMapper mapper;
	@Autowired
	public void setMapper(UniversityDynamicMapper mapper){
		this.mapper = mapper;
		super.setMapper(mapper);
	}
	@Override
	public List selectByUniversityId(int id) {
		List<UniversityDynamic> selectByUniversityId = mapper.selectByUniversityId(id);
		return selectByUniversityId;
	}
	@Override
	public Long addSelective(UniversityDynamic re) {
		re.setRsDatetime(new Date());
		Long addSelective = mapper.addSelective(re);
		return addSelective;
	}
	@Override
	public Long updateSelective(UniversityDynamic ud) {
		ud.setRsDatetime(new Date());
		Long updateSelective = mapper.updateSelective(ud);
		return updateSelective;
	}

	

}

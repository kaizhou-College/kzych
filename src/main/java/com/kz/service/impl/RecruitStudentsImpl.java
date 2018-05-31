package com.kz.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kz.core.service.BaseService;
import com.kz.dao.RecruitStudentsMapper;
import com.kz.po.RecruitStudents;
import com.kz.po.RecruitStudentsQuery;
import com.kz.service.IRecruitStudents;
@Service
@Transactional
public class RecruitStudentsImpl extends BaseService<RecruitStudents, RecruitStudentsQuery> implements IRecruitStudents  {
	private RecruitStudentsMapper mapper;
	@Autowired
	public void setMapper(RecruitStudentsMapper mapper){
		this.mapper = mapper;
		super.setMapper(mapper);
	}
	@Override
	public List selectByUniversityId(int id) {
		List<RecruitStudents> selectByUniversityId = mapper.selectByUniversityId(id);
		return selectByUniversityId;
	}
	@Override
	public Long addSelective(RecruitStudents re) {
		Long addSelective = mapper.addSelective(re);
		return addSelective;
	}

	

}

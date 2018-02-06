package com.kz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kz.core.service.BaseService;
import com.kz.dao.MajorMapper;
import com.kz.po.Major;
import com.kz.po.MajorQuery;
import com.kz.po.MajorUniversity;

@Service
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

}

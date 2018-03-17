package com.kz.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.github.pagehelper.PageInfo;
import com.kz.core.dao.BaseMapper;
import com.kz.po.University;
import com.kz.po.UniversityQuery;

@Repository
public interface UniversityMapper extends BaseMapper<University, UniversityQuery>{

	University selectMajorsPageById(Long id);
	List<University> listKeyPublishStatus(UniversityQuery uq);
}
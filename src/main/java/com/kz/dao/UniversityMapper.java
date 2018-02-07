package com.kz.dao;

import org.springframework.stereotype.Repository;

import com.kz.core.dao.BaseMapper;
import com.kz.po.University;
import com.kz.po.UniversityQuery;

@Repository
public interface UniversityMapper extends BaseMapper<University, UniversityQuery>{

	University selectMajorsPageById(Long id);
}
package com.kz.service;
import java.util.List;

import com.kz.core.service.IBaseService;
import com.kz.po.RecruitStudents;
import com.kz.po.RecruitStudentsQuery;

public interface IRecruitStudents extends IBaseService<RecruitStudents, RecruitStudentsQuery>{

	List selectByUniversityId(int id); 
	
	Long addSelective(RecruitStudents re);
}

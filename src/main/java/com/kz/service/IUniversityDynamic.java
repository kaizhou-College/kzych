package com.kz.service;
import java.util.List;

import com.kz.core.service.IBaseService;
import com.kz.po.UniversityDynamic;
import com.kz.po.UniversityDynamicQuery;

public interface IUniversityDynamic extends IBaseService<UniversityDynamic, UniversityDynamicQuery>{

	List selectByUniversityId(int id); 
	
	Long addSelective(UniversityDynamic re);
}

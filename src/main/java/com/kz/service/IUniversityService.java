package com.kz.service;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kz.core.common.ServerResponse;
import com.kz.core.service.IBaseService;
import com.kz.po.Major;
import com.kz.po.University;
import com.kz.po.UniversityQuery;
import com.kz.po.User;
import com.kz.po.UserQuery;

public interface IUniversityService extends IBaseService<University, UniversityQuery>{

	University selectMajorsPageById(Long id, int pageNum, int pageSize);
	PageInfo listKeyPublishStatus(UniversityQuery qu);
	List categoryList(); 
	Long insertSelectiveSequence(University m);
	Long updateByKeySelective(University m);
	List<University> schoolByUserIdList(University m);
	Long schoolByUserIdUpdate(University m);
	PageInfo<University> schoolByIsNotHotList(UniversityQuery hq);
	PageInfo<University> schoolAddressList(UniversityQuery hq);
}

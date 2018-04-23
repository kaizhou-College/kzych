package com.kz.service;

import com.github.pagehelper.PageInfo;
import com.kz.core.service.IBaseService;
import com.kz.po.Major;
import com.kz.po.MajorCategory;
import com.kz.po.MajorCategoryQuery;
import com.kz.po.MajorQuery;
import com.kz.po.MajorUniversity;

public interface IMajorService extends IBaseService<Major, MajorQuery>{

	MajorUniversity findByUniversityId(int universityId, int majorId);

	PageInfo<MajorCategory> majorCategorylist(MajorCategoryQuery qm);
}

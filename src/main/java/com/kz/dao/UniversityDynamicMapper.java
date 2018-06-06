package com.kz.dao;

import java.util.List;

import com.kz.core.dao.BaseMapper;
import com.kz.po.Comment;
import com.kz.po.CommentQuery;
import com.kz.po.UniversityDynamic;
import com.kz.po.UniversityDynamicQuery;

public interface UniversityDynamicMapper extends BaseMapper<UniversityDynamic,UniversityDynamicQuery>{
    List<UniversityDynamic> selectByUniversityId(int universityId);
    Long addSelective(UniversityDynamic re);
}
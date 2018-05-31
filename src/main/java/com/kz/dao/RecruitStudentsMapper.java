package com.kz.dao;

import java.util.List;

import com.kz.core.dao.BaseMapper;
import com.kz.po.Comment;
import com.kz.po.CommentQuery;
import com.kz.po.RecruitStudents;
import com.kz.po.RecruitStudentsQuery;

public interface RecruitStudentsMapper extends BaseMapper<RecruitStudents,RecruitStudentsQuery>{
    List<RecruitStudents> selectByUniversityId(int universityId);
    Long addSelective(RecruitStudents re);
}
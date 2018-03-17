package com.kz.dao;

import org.springframework.stereotype.Repository;

import com.kz.core.dao.BaseMapper;
import com.kz.po.Comment;
import com.kz.po.CommentQuery;
import com.kz.po.CommentWithBLOBs;
@Repository
public interface CommentMapper extends BaseMapper<Comment,CommentQuery> {
	
	Long accordingNewsIdAddComment(CommentWithBLOBs co); 
}
package com.kz.service;

import com.kz.core.service.IBaseService;
import com.kz.po.Comment;
import com.kz.po.CommentQuery;
import com.kz.po.CommentWithBLOBs;

public interface ICommentService extends IBaseService<Comment,CommentQuery>{
	
	Long accordingNewsIdAddComment(CommentWithBLOBs co);
}

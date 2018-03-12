package com.kz.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alipay.api.domain.ServiceContext;
import com.kz.core.service.BaseService;
import com.kz.dao.CommentMapper;
import com.kz.dao.NewsMapper;
import com.kz.po.Comment;
import com.kz.po.CommentQuery;
import com.kz.po.CommentWithBLOBs;
import com.kz.po.News;
import com.kz.service.ICommentService;
@Service
@Transactional
public class CommentServiceImpl extends BaseService<Comment,CommentQuery> implements ICommentService {
	private CommentMapper mapper;
	@Autowired
	public void setMapper(CommentMapper mapper){
		this.mapper = mapper;
		super.setMapper(mapper);
	}
	@Autowired
	private NewsMapper newMapper;
	@Override
	public Long accordingNewsIdAddComment(CommentWithBLOBs co) {
		Long accordingNewsIdAddComment = mapper.accordingNewsIdAddComment(co);
		//如果添加评论成功就才进入新闻表里面修改评论数
		if(accordingNewsIdAddComment>0){
			News news = new News();
			news.setId(co.getCommentId());
			Long updateByPrimaryKeyCommentnum = newMapper.updateByPrimaryKeycommentNum(news);
			if(updateByPrimaryKeyCommentnum>0){
				return updateByPrimaryKeyCommentnum;
			}
		}
		return null;
	}
	
}

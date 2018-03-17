package com.kz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.kz.core.dao.BaseMapper;
import com.kz.core.service.BaseService;
import com.kz.dao.NewsMapper;
import com.kz.dao.UniversityMapper;
import com.kz.po.News;
import com.kz.po.NewsQuery;
import com.kz.service.INewsService;

@Service
@Transactional
public class NewsServiceImpl extends BaseService<News, NewsQuery> implements INewsService{
	private NewsMapper mapper;
	@Autowired
	public void setMapper(NewsMapper mapper){
		this.mapper = mapper;
		super.setMapper(mapper);
		
	}
	@Override
	public List<News> dimContentPage(NewsQuery qu) {
		PageHelper.startPage(qu.getPageNum(),qu.getPageSize());
		return mapper.dimContentPage(qu);
	}
	@Override
	public Long whileKeyUpdateHit(News co) {
		return mapper.whileKeyUpdateHit(co);
	}
}

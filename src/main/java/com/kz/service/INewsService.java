package com.kz.service;

import java.util.List;

import com.kz.core.service.IBaseService;
import com.kz.po.News;
import com.kz.po.NewsQuery;

public interface INewsService extends IBaseService<News,NewsQuery>{
	List<News> dimContentPage(NewsQuery co);
	Long whileKeyUpdateHit(News co);
}

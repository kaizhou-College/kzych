package com.kz.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kz.core.dao.BaseMapper;
import com.kz.po.News;
import com.kz.po.NewsQuery;
@Repository
public interface NewsMapper extends BaseMapper<News, NewsQuery> {
    List<News> dimContentPage(NewsQuery co);
    Long whileKeyUpdateHit(News co);
}
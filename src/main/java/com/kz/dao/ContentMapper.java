package com.kz.dao;

import com.kz.po.Content;
import com.kz.po.ContentWithBLOBs;

public interface ContentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ContentWithBLOBs record);

    int insertSelective(ContentWithBLOBs record);

    ContentWithBLOBs selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ContentWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ContentWithBLOBs record);

    int updateByPrimaryKey(Content record);
}
package com.kz.dao;

import com.kz.po.Channel;

public interface ChannelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Channel record);

    int insertSelective(Channel record);

    Channel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Channel record);

    int updateByPrimaryKeyWithBLOBs(Channel record);

    int updateByPrimaryKey(Channel record);
}
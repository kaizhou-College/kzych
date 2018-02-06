package com.kz.dao;

import com.kz.po.OrderModel;

public interface OrderModelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OrderModel record);

    int insertSelective(OrderModel record);

    OrderModel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderModel record);

    int updateByPrimaryKey(OrderModel record);
}
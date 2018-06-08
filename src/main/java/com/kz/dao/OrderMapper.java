package com.kz.dao;

import java.util.List;

import com.kz.core.dao.BaseMapper;
import com.kz.po.Order;
import com.kz.po.OrderQuery;

public interface OrderMapper extends BaseMapper<Order, OrderQuery>{
	Order selectByOrderNo(Long orderNo);

	Long myInsertSelective(Order order);

	List<Order> orderByUseridSelect(Long userId);
   
}
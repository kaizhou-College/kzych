package com.kz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.kz.core.service.BaseService;
import com.kz.dao.OrderDetailMapper;
import com.kz.dao.OrderMapper;
import com.kz.po.Order;
import com.kz.po.OrderDetail;
import com.kz.po.OrderQuery;
import com.kz.service.IOrderService;
import com.kz.vo.OrderVo;

@Service
public class OrderServiceImpl extends BaseService<Order, OrderQuery> implements IOrderService {
	private OrderMapper orderMapper = null;
	@Autowired
	public void setMapper(OrderMapper orderMapper){
		this.orderMapper = orderMapper;
		super.setMapper(orderMapper);
	}
	@Autowired
	private OrderDetailMapper orderDetailMapper;
	@Override
	public boolean create(Order order, OrderDetail orderDetail) {
		//1，添加订单
		Long orderId = orderMapper.insert(order);
		//2,添加订单详情
		orderDetail.setOrderid(orderId);
		Long orderDetailId = orderDetailMapper.insert(orderDetail);
		if(orderId>0 && orderDetailId >0){
			return true;
		}else{
			return false;
		}
		
		
	}
	
	

}

package com.kz.service;

import com.kz.core.common.ServerResponse;
import com.kz.core.service.IBaseService;
import com.kz.po.MajorUniversity;
import com.kz.po.Order;
import com.kz.po.OrderDetail;
import com.kz.po.OrderQuery;

public interface IOrderService extends IBaseService<Order, OrderQuery>{

	boolean create(Order order,OrderDetail orderDetail);

	ServerResponse pay(Long orderNo, Long uuid);

}

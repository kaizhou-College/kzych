package com.kz.service;

import com.kz.core.common.ServerResponse;
import com.kz.core.service.IBaseService;
import com.kz.po.MajorUniversity;
import com.kz.po.Order;
import com.kz.po.OrderDetail;
import com.kz.po.OrderQuery;
import com.kz.po.University;
import com.kz.po.UniversityQuery;
import com.kz.po.User;

public interface IOrderService extends IBaseService<Order, OrderQuery>{

	boolean create(Order order,OrderDetail orderDetail);

	ServerResponse pay(Long orderNo, Long uuid);

	Long order_create(User u, UniversityQuery qu);

}

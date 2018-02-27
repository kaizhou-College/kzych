package com.kz.web.controller.portal;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.kz.core.common.Const;
import com.kz.core.common.ServerResponse;
import com.kz.po.Order;
import com.kz.po.OrderDetail;
import com.kz.po.User;
import com.kz.service.IOrderService;
import com.kz.vo.OrderVo;

@Controller
@RequestMapping("/order/")
public class OrderController {
	private Logger logger = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	private IOrderService iOrderService;

	/*
	 * {
		 "universtityId":1,
		 "majorId":2,
		 "cost":2222.22,
		 "paymentType":10,
		 "coupon":3333.33,
		 "grants":1000.00
		 "payment":2000.99
	 * }
	 */
	@RequestMapping("create.do")
	@ResponseBody
	public ServerResponse<PageInfo> create(@RequestBody OrderVo orderVo, HttpSession session) {
		// 1,TODO 登陆验证---拦截器
		// 2,创建订单和订单详情
		logger.info("orderVo==="+orderVo.toString());
		//2.1,创建订单
		Order order = new Order();
		order.setPayment(orderVo.getPayment());
		//User curUser = (User) session.getAttribute(Const.CURRENT_USER);
		//TODO 测试用
		User curUser = new User();
		curUser.setUuid(1L);
		order.setUuid(curUser.getUuid());
		order.setPaymentType(orderVo.getPaymentType());
		order.setStatus(Const.OrderStatusEnum.NO_PAY.getCode());
		//2.2创建订单详情
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setCost(orderVo.getCost());
		orderDetail.setCoupon(orderVo.getCoupon());
		orderDetail.setGrants(orderVo.getGrants());
		orderDetail.setMajorId(orderVo.getMajorId());
		orderDetail.setUniversityId(orderVo.getUniverstityId());
		
		//3，添加到数据库
		iOrderService.create(order,orderDetail);
		

		return ServerResponse.createBySuccessMessage("下订单成功！！！");
	}
}

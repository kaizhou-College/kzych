package com.kz.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.kz.core.common.ServerResponse;
import com.kz.core.service.BaseService;
import com.kz.dao.OrderDetailMapper;
import com.kz.dao.OrderMapper;
import com.kz.dao.UniversityMapper;
import com.kz.dao.UserMapper;
import com.kz.po.Order;
import com.kz.po.OrderDetail;
import com.kz.po.OrderQuery;
import com.kz.po.University;
import com.kz.po.UniversityQuery;
import com.kz.po.User;
import com.kz.service.IOrderService;
import com.kz.utils.ZfbPropertiesUtil;
import com.kz.web.controller.portal.OrderController;

@Service
@Transactional
public class OrderServiceImpl extends BaseService<Order, OrderQuery>implements IOrderService {
	private Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	private OrderMapper orderMapper = null;

	@Autowired
	public void setMapper(OrderMapper orderMapper) {
		this.orderMapper = orderMapper;
		super.setMapper(orderMapper);
	}

	@Autowired
	private OrderDetailMapper orderDetailMapper;

	@Autowired
	private UserMapper usermapper;
	
	@Autowired
	private UniversityMapper universityMapper;
	
	public boolean create(Order order, OrderDetail orderDetail) {
		// 1，添加订单
		// 生产订单号
		long orderNo = this.generateOrderNo();
		order.setOrderNo(orderNo);
		Long orderId = orderMapper.insert(order);
		// 2,添加订单详情
		orderDetail.setOrderid(orderId);
		Long orderDetailId = orderDetailMapper.insert(orderDetail);
		if (orderId > 0 && orderDetailId > 0) {
			return true;
		} else {
			return false;
		}
	}

	/* 支付 */
	public ServerResponse pay(Long orderNo, Long uuid) {
		// 实例化客户端
		String ServerUrl = ZfbPropertiesUtil.getProperty("open_api_domain");
		String appId = ZfbPropertiesUtil.getProperty("appid");
		String primaryKey = ZfbPropertiesUtil.getProperty("private_key");
		String charset = ZfbPropertiesUtil.getProperty("utf-8");
		String alipayPublicKey = ZfbPropertiesUtil.getProperty("alipay_public_key");
		AlipayClient alipayClient = new DefaultAlipayClient(ServerUrl, appId, primaryKey, "json", charset,
				alipayPublicKey, "RSA2");
		// 实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
		AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
		// SDK已经封装掉了公共参数，这里只需要传入业务参数。
		// 以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
		//1,得到订单对象
		Order tmpOrder = orderMapper.selectByOrderNo(orderNo);
		
		
		
		AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
		model.setBody("购买了欧乐B电动牙刷一只");
		model.setSubject("电动牙刷");
		model.setOutTradeNo(tmpOrder.getOrderNo().toString());
		model.setTimeoutExpress("30m");
		model.setTotalAmount(tmpOrder.getPayment().toString());
		model.setProductCode("QUICK_MSECURITY_PAY");
		request.setBizModel(model);
		// request.setNotifyUrl("商户外网可以访问的异步地 址");
		try {
			// 这里和普通的接口调用不同，使用的是sdkExecute
			AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
			//System.out.println(response.getBody());// 就是orderString
			logger.info("请求参数加签成功....");
			return ServerResponse.createBySuccess("参数加签成功！", response.getBody());										// 可以直接给客户端请求，无需再做处理。
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
		return ServerResponse.createByErrorMessage("参数加签失败");
	}

	private long generateOrderNo() {
		long currentTime = System.currentTimeMillis();
		return currentTime + new Random().nextInt(100);
	}

	@Override
	public Long order_create(User u, UniversityQuery qu) {
		Long userId=0L;
		double grants;//助学金
		double coupon;//优惠金额
		double cost;//学费
		//需要传入 universityId majorId 以及user的值
		//先创建用户
		u.setCreateTime(new Date());
		Long userAdd=usermapper.userInfoAdd(u);
		//然后使用该用户身份证查询出该用户id
		if(userAdd>0){
			List<User> userList = usermapper.userByIdCardSelect(u.getIdcard());
			userId=userList.get(0).getUuid();
		}
		//接着查询出university中的优惠券 university_major的学费
		University costDetail = universityMapper.UniversityCostDetail(qu);
		grants=costDetail.getGrants().doubleValue();
		coupon=costDetail.getCoupon().doubleValue();
		cost=Double.parseDouble(costDetail.getMajors().get(0).getCostDetail());
		//那么就添加order  PAYMENT字段使用学费减掉优惠券
		Order order=new Order();
		order.setUserId(userId);
		order.setCreateTime(new Date());
		order.setPayment(new BigDecimal(cost-coupon-grants));
		order.setStatus(0);
		Long orderAdd=orderMapper.myInsertSelective(order);
		//最后根据orderd用户id降序查询出第一条数据的id
		//收尾完成orderDetail的数据添加
		return null;
	}
}

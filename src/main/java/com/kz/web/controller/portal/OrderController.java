package com.kz.web.controller.portal;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.kz.core.common.Const;
import com.kz.core.common.ResponseCode;
import com.kz.core.common.ServerResponse;
import com.kz.po.Order;
import com.kz.po.OrderDetail;
import com.kz.po.University;
import com.kz.po.UniversityQuery;
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
		order.setUserId(curUser.getUuid());
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
	/**
	 * 
	 * @Title: pay 
	 * @Description: 后台支付接口完成支付请求并返回orderString直接返回给app
	 * @param: @param session
	 * @param: @param orderNo
	 * @param: @param request
	 * @param: @return
	 * @return: ServerResponse 返回值类型
	 */
	@RequestMapping("pay.do")
    @ResponseBody
    public ServerResponse pay(HttpSession session, Long orderNo, HttpServletRequest request){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user ==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return iOrderService.pay(orderNo,user.getUuid());
    }
	@RequestMapping("alipay_callback.do")
    @ResponseBody
    public Object alipayCallback(HttpServletRequest request){
        Map<String,String> params = Maps.newHashMap();

        Map requestParams = request.getParameterMap();
        for(Iterator iter = requestParams.keySet().iterator();iter.hasNext();){
            String name = (String)iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for(int i = 0 ; i <values.length;i++){

                valueStr = (i == values.length -1)?valueStr + values[i]:valueStr + values[i]+",";
            }
            params.put(name,valueStr);
        }
        logger.info("支付宝回调,sign:{},trade_status:{},参数:{}",params.get("sign"),params.get("trade_status"),params.toString());

        //非常重要,验证回调的正确性,是不是支付宝发的.并且呢还要避免重复通知.

        params.remove("sign_type");
       /* try {
//            /boolean alipayRSACheckedV2 = AlipaySignature.rsaCheckV2(params, Configs.getAlipayPublicKey(),"utf-8",Configs.getSignType());

            if(!alipayRSACheckedV2){
                return ServerResponse.createByErrorMessage("非法请求,验证不通过,再恶意请求我就报警找网警了");
            }
        } catch (AlipayApiException e) {
            logger.error("支付宝验证回调异常",e);
        }*/

        //todo 验证各种数据


        //
      //  ServerResponse serverResponse = iOrderService.aliCallback(params);
       /* if(serverResponse.isSuccess()){
            return Const.AlipayCallback.RESPONSE_SUCCESS;
        }*/
        return Const.AlipayCallback.RESPONSE_FAILED;
    }
	
	
	//微信小程序的报名
	@RequestMapping(value="order_create.do")
	public ServerResponse order_create(User u,UniversityQuery qu){
		Long num=iOrderService.order_create(u,qu);
		//需要传入 universityId majorId 以及user的值
		//先创建用户
		//然后使用该用户身份证查询出该用户id
		//接着查询出university中的优惠券 university_major的学费
		//那么就添加order  PAYMENT字段使用学费减掉优惠券
		//最后根据orderd用户id降序查询出第一条数据的id
		//收尾完成orderDetail的数据添加
		if(num==2L){
			return ServerResponse.createBySuccessMessage("报名成功");
		}else{
			return ServerResponse.createBySuccessMessage("报名失败");
		}
		
	}
}

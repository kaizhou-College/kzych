package com.kz.web.intercept;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.kz.core.common.Const;
import com.kz.po.User;

public class LoginIntercept implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		String uri = request.getRequestURI();
		if(uri.indexOf("order/create.do")>0
				||uri.indexOf("order/pay.do")>0
				){
			HttpSession session=request.getSession();
			User attribute =(User)session.getAttribute(Const.CURRENT_USER);
			if(attribute!=null){
				return true;
			}else{
//				response.sendRedirect("/kzych/user/login.do");
				response.sendRedirect("/front/login.jsp");
			}
		}
		return true;
	}

}

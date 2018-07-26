package com.kz.web.controller.portal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kz.core.common.Const;
import com.kz.core.common.ServerResponse;
import com.kz.po.User;
import com.kz.po.WxBindInfo;
import com.kz.po.WxBindInfoQuery;
import com.kz.service.IUniversityService;
import com.kz.service.IWxUserService;

@Controller
@RequestMapping("/wx_user/")
public class WxUserController {
	@Autowired
	private IWxUserService iWxUserService;
	
	@RequestMapping(value="login.do", method = RequestMethod.POST)
	@ResponseBody
	public ServerResponse<WxBindInfo> login(WxBindInfoQuery wx,HttpSession session) {
		ServerResponse<WxBindInfo> response = iWxUserService.login(wx);
		if (response.isSuccess()) {
			session.setAttribute(Const.CURRENT_USER, response.getData());
		}
		return response;
	}
	
	/*
		wxUsername
		gender
		mobile
		school
		originplace
		idcard
		nickname*/
	@RequestMapping(value = "register.do", method = RequestMethod.POST)
	@ResponseBody
	public ServerResponse<String> register(@RequestBody WxBindInfo wx,HttpSession session) {
		ServerResponse<String> register = iWxUserService.register(wx);
		return register;
	}
}

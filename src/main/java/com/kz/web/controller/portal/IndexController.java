package com.kz.web.controller.portal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class IndexController {
	

	@RequestMapping(value="front/index.do")
	public String toFrontIndex(){
		return "/front/index";
	}
	@RequestMapping(value="front/register.do")
	public String toFrontRegister(){
		return "/front/register";
	}
	@RequestMapping(value="front/login.do")
	public String toFrontLogin(){
		return "/front/login";
	}
	@RequestMapping(value="front/usertype.do")
	public String toFrontUserType(){
		return "/front/usertype";
	}
	/**
	 * @Title: toIndex
	 * @Description: 跳往初始页面
	 * @param: @return
	 * @return: String 返回值类型
	 */
	@RequestMapping(value="index.do")
	public String toIndex(){
		return "/admin/index";
	}
	/**
	 * @Title: toSettingApp
	 * @Description: 跳往系统管理的初始页面
	 * @param: @return
	 * @return: String 返回值类型
	 */
	@RequestMapping(value="settingApp.do")
	public String toSettingApp(){
		return "/admin/setting_app";
	}
}

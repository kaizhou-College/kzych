package com.kz.web.controller.portal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class IndexController {
	
	/**
	 * @Title: toIndex
	 * @Description: 跳往初始页面
	 * @param: @return
	 * @return: String 返回值类型
	 */
	@RequestMapping(value="index.do", method = RequestMethod.POST)
	public String toIndex(){
		return "index";
	}
	/**
	 * @Title: toSettingApp
	 * @Description: 跳往系统管理的初始页面
	 * @param: @return
	 * @return: String 返回值类型
	 */
	@RequestMapping(value="settingApp.do", method = RequestMethod.POST)
	public String toSettingApp(){
		return "setting_app";
	}
}

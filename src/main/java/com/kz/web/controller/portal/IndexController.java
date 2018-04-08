package com.kz.web.controller.portal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
	
	/**
	 * @Title: toIndex
	 * @Description: 跳往初始页面
	 * @param: @return
	 * @return: String 返回值类型
	 */
	@RequestMapping("index.do")
	public String toIndex(){
		return "index";
	}
	/**
	 * @Title: toSettingApp
	 * @Description: 跳往系统管理的初始页面
	 * @param: @return
	 * @return: String 返回值类型
	 */
	@RequestMapping("settingApp.do")
	public String toSettingApp(){
		return "setting_app";
	}
}

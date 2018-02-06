package com.kz.web.controller.portal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.kz.core.common.ServerResponse;
import com.kz.po.University;
import com.kz.po.UniversityQuery;
import com.kz.service.IUniversityService;

@Controller
@RequestMapping("/university/")
public class UniversityController {
	@Autowired
	private IUniversityService iUniversityService;
	
	@RequestMapping("list.do")
	@ResponseBody
	public ServerResponse<PageInfo<University>> list(UniversityQuery uq,Model model){
		//TODO　1,验证是否登陆
		PageInfo<University> pageInfo = iUniversityService.getByConditionPage(uq);
		//页面显示数据
		return ServerResponse.createBySuccess("查询成功", pageInfo);
	}
	
	@RequestMapping("university_detail.do")
	@ResponseBody
	public ServerResponse<University> list(Long universityId,int pageNum,int pageSize){
		if(pageNum==0){
			pageNum=1;
		}
		if(pageSize==0){
			pageSize = 8;
		}
		//TODO　1,验证是否登陆
		//3，根据学校的id查询该学校的所有专业信息
		University university = iUniversityService.selectMajorsPageById(universityId,pageNum,pageSize);
		
		//页面显示数据
		return ServerResponse.createBySuccess("查询成功", university);
	}
}

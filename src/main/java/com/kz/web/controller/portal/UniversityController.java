package com.kz.web.controller.portal;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.kz.core.common.Const;
import com.kz.core.common.ResponseCode;
import com.kz.core.common.ServerResponse;
import com.kz.po.University;
import com.kz.po.UniversityQuery;
import com.kz.po.User;
import com.kz.service.IFileService;
import com.kz.service.IUniversityService;
import com.kz.service.IUserService;
import com.kz.utils.PropertiesUtil;

import alipay.api.domain.Data;

@Controller
@RequestMapping("/university/")
public class UniversityController {
	@Autowired
	private IUniversityService iUniversityService;
	
	@Autowired
	private IUserService iUserService;
	
	@Autowired
    private IFileService iFileService;
	
	//学校首页
	@RequestMapping(value="index.do",method=RequestMethod.GET) 
	public String SchoolIndex(){
		return "schoollist";
	}
	//跳转到审查学校
	@RequestMapping(value="schoolAuditTo.do",method=RequestMethod.GET) 
	public String SchoolAudit(){
		return "school_audit";
	}
	//跳转到未通过学校
	@RequestMapping(value="schoolNopassTo.do",method=RequestMethod.GET) 
	public String SchoolNopass(){
		return "nopass_schools";
	}
	@RequestMapping("schoolList.do")
	@ResponseBody
	public ServerResponse<PageInfo> list(UniversityQuery uq) {
		// TODO 1,验证是否登陆
		PageInfo pageInfo = iUniversityService.getByConditionPage(uq);
		// 页面显示数据
		return ServerResponse.createBySuccess("查询成功", pageInfo);
	}
	@RequestMapping("schoolListPageWithConditions.do")
	@ResponseBody
	public ServerResponse<PageInfo> listKeyPublishStatus(UniversityQuery qu){
		//按条件分页查询
		PageInfo pageInfo = iUniversityService.listKeyPublishStatus(qu);
		return ServerResponse.createBySuccess("查询成功", pageInfo);
	}
	@RequestMapping("dimListPage.do")
	@ResponseBody
	public PageInfo  dimListPage(HttpServletResponse resp,UniversityQuery qu){
		//ajax   按地址分页
		PageInfo pageInfo = iUniversityService.listKeyPublishStatus(qu);
		return pageInfo;
	}
	
	@RequestMapping("university_detail.do")
	@ResponseBody
	public ServerResponse<University> list(Long universityId, int pageNum, int pageSize) {
		if (pageNum == 0) {
			pageNum = 1;
		}
		if (pageSize == 0) {
			pageSize = 8;
		}
		// TODO 1,验证是否登陆
		// 3，根据学校的id查询该学校的所有专业信息
		University university = iUniversityService.selectMajorsPageById(universityId, pageNum, pageSize);

		// 页面显示数据
		return ServerResponse.createBySuccess("查询成功", university);
	}

	@RequestMapping("save.do")
	@ResponseBody
	public ServerResponse save(HttpSession session,
			@RequestParam(value = "upload_file", required = false) 
			MultipartFile file, 
			HttpServletRequest request) {
		User user = (User) session.getAttribute(Const.CURRENT_USER);
		if (user == null) {
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录,请登录管理员");
		}
		if (iUserService.checkAdminRole(user).isSuccess()) {
			String path = request.getSession().getServletContext().getRealPath("upload");
			String targetFileName = iFileService.upload(file, path);
			String url = PropertiesUtil.getProperty("ftp.server.http.prefix") + targetFileName;

			Map fileMap = Maps.newHashMap();
			fileMap.put("uri", targetFileName);
			fileMap.put("url", url);
			return ServerResponse.createBySuccess(fileMap);
		} else {
			return ServerResponse.createByErrorMessage("无权限操作");
		}
	}
}

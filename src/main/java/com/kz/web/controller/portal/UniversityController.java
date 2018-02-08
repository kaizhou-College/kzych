package com.kz.web.controller.portal;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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

@Controller
@RequestMapping("/university/")
public class UniversityController {
	@Autowired
	private IUniversityService iUniversityService;
	
	@Autowired
	private IUserService iUserService;
	
	@Autowired
    private IFileService iFileService;

	@RequestMapping("list.do")
	@ResponseBody
	public ServerResponse<PageInfo<University>> list(UniversityQuery uq, Model model) {
		// TODO 1,验证是否登陆
		PageInfo<University> pageInfo = iUniversityService.getByConditionPage(uq);
		// 页面显示数据
		return ServerResponse.createBySuccess("查询成功", pageInfo);
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

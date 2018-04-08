package com.kz.web.controller.portal;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
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
import com.kz.po.UniversityCategory;
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

	// 按照学校id来修改该学校
	@RequestMapping("schoolByUserIdUpdate.do")
	public void schoolByUserIdUpdate(University m, HttpServletResponse re) {
		Long result = iUniversityService.schoolByUserIdUpdate(m);

		try {
			re.sendRedirect("/kzych/user/userinfoTo.do");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 按照用户id来查找该学校
	@RequestMapping("schoolByUserIdList.do")
	public void schoolByUserIdList(University m, HttpServletResponse re) {
		PrintWriter out = null;
		try {
			out = re.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<University> result = iUniversityService.schoolByUserIdList(m);
		if (result != null) {
			out.print(result.get(0).getCheckedInfo());
		} else {
			out.print("失败");
		}
	}

	// 按学校id查询 并且修改这一条数据（但审核时点击通过或者不通过时需要修改Cookie中的值 但我的Cookie中名字是跟表数据有关系的）
	@RequestMapping("updatePublicStatus.do")
	public void universityUpdatePublicString(University m, HttpServletResponse re) {
		PrintWriter out = null;
		try {
			out = re.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Long result = iUniversityService.updateByKeySelective(m);
		if (result == 1L) {
			University university = iUniversityService.selectByPrimaryKey(m.getId());
			out.print(university.getUserId());
		} else {
			out.print("失败");
		}

	}

	// 为该用户添加一所学校
	@RequestMapping("universityAdd.do")
	public void universityAdd(University m, HttpServletResponse re) {
		PrintWriter out = null;
		try {
			out = re.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Long long1 = iUniversityService.insertSelectiveSequence(m);
		if (long1 == 1L) {
			out.print("请求成功");
		} else {
			out.print("请求失败");
		}
	}

	// 查询学校的全部等级（kz_university_category）
	@RequestMapping("categoryList.do")
	@ResponseBody
	public List<UniversityCategory> categoryList() {
		List<UniversityCategory> list = iUniversityService.categoryList();
		return list;
	}

	// 从前台跳到普通用户后台
	@RequestMapping(value = "productTO.do", method = RequestMethod.GET)
	public String productTO(HttpSession session) {
		// 由于页面加载时级需要查询状态所以就在在里做查询了
		User u = (User) session.getAttribute(Const.CURRENT_USER);
		University un = new University();
		long userid = u.getUuid();
		un.setUserId((int) userid);
		List<University> result = iUniversityService.schoolByUserIdList(un);
		session.setAttribute("publicStatus", result.get(0).getPublishStatus());
		session.setAttribute("User_list", result.get(0));
		return "product";
	}


	// 学校首页 （也是从前台跳到管理员后台）
	@RequestMapping(value = "index.do", method = RequestMethod.GET)
	public String SchoolIndex() {
		return "schoollist";
	}

	// 跳转到审查学校
	@RequestMapping(value = "schoolAuditTo.do", method = RequestMethod.GET)
	public String SchoolAudit() {
		return "school_audit";
	}

	// 跳转到未通过学校
	@RequestMapping(value = "schoolNopassTo.do", method = RequestMethod.GET)
	public String SchoolNopass() {
		return "nopass_schools";
	}



	@RequestMapping("schoolListPageWithConditions.do")
	@ResponseBody
	public ServerResponse<PageInfo> listKeyPublishStatus(UniversityQuery qu) {
		// 按条件分页查询
		PageInfo pageInfo = iUniversityService.listKeyPublishStatus(qu);
		return ServerResponse.createBySuccess("查询成功", pageInfo);
	}

	@RequestMapping("dimListPage.do")
	@ResponseBody
	public PageInfo dimListPage(HttpServletResponse resp, UniversityQuery qu) {
		// ajax 按地址分页

		// 解决乱码问题
		String provid = qu.getProvid();
		String cityid = qu.getCityid();
		String areaid = qu.getAreaid();
		String search_key = qu.getSearch_key();
		try {
			provid = new String(provid.getBytes("iso-8859-1"), "UTF-8");
			cityid = new String(cityid.getBytes("iso-8859-1"), "UTF-8");
			areaid = new String(areaid.getBytes("iso-8859-1"), "UTF-8");
			search_key = new String(search_key.getBytes("iso-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		qu.setProvid(provid);
		qu.setCityid(cityid);
		qu.setAreaid(areaid);
		qu.setSearch_key(search_key);
		PageInfo pageInfo = iUniversityService.listKeyPublishStatus(qu);
		return pageInfo;
	}

	@RequestMapping("schoolList.do")
	@ResponseBody
	public ServerResponse<PageInfo> list(UniversityQuery uq,HttpSession session) {
		User user = (User) session.getAttribute(Const.CURRENT_USER);
		if (user == null) {
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录,请登录管理员");
		}
		PageInfo pageInfo = iUniversityService.getByConditionPage(uq);
		// 页面显示数据
		return ServerResponse.createBySuccess("查询成功", pageInfo);
	}
	
	
	@RequestMapping("university_detail.do")
	@ResponseBody
	public ServerResponse<University> list(HttpSession session ,Long universityId, int pageNum, int pageSize) {
		if (pageNum == 0) {
			pageNum = 1;
		}
		if (pageSize == 0) {
			pageSize = 8;
		}
		User user = (User) session.getAttribute(Const.CURRENT_USER);
		if (user == null) {
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录,请登录管理员");
		}
		// 3，根据学校的id查询该学校的所有专业信息
		University university = iUniversityService.selectMajorsPageById(universityId, pageNum, pageSize);

		// 页面显示数据
		return ServerResponse.createBySuccess("查询成功", university);
	}

	@RequestMapping("save.do")
	@ResponseBody
	public ServerResponse save(HttpSession session,
			@RequestParam(value = "upload_file", required = false) MultipartFile file, HttpServletRequest request) {
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

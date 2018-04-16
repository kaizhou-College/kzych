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
	
	
	/**
	 * 
	 * @Title: schoolByUserIdUpdate
	 * @Description: 按照学校id来修改该学校
	 * @param: @param
	 *             id
	 * @param: @param
	 *             universityType
	 * @param: @param
	 *             universityNature
	 * @param: @param
	 *             categoryid
	 * @param: @param
	 *             address
	 * @param: @param
	 *             legalPersonName
	 * @param: @param
	 *             legalPersonCard
	 * @param: @param
	 *             legalPersonPhone
	 * @param: @param
	 *             introduction
	 * @param: @param
	 *             re
	 */
	@RequestMapping(value="schoolByUserIdUpdate.do", method = RequestMethod.POST)
	public void schoolByUserIdUpdate(University m, HttpServletResponse response,HttpServletRequest request) {
		Long result = iUniversityService.schoolByUserIdUpdate(m);

		try {
//			response.sendRedirect("/kzych/user/userinfoTo.do");
			response.sendRedirect("/user/userinfoTo.do");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @Title: schoolByUserIdList
	 * @Description: 按照用户id来查找该学校
	 * @param: @param
	 *             userId
	 * @param: @param
	 *             re
	 */
	@RequestMapping(value="schoolByUserIdList.do", method = RequestMethod.POST)
	public void schoolByUserIdList(University m, HttpServletResponse re) {
		PrintWriter out = null;
		try {
			out = re.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<University> result = iUniversityService.schoolByUserIdList(m);
		if (result.size()>0) {
			out.print(result.get(0).getCheckedInfo());
		} else {
			out.print("失败");
		}
	}
	/**
	 * 
	 * @Title: universityUpdatePublicString
	 * @Description: 按学校id查询 并且修改这一条数据（但审核时点击通过或者不通过时需要修改Cookie中的值 但我的Cookie中名字是跟表数据有关系的）
	 * @param: @param
	 *             id
	 * @param: @param
	 *             publishStatus
	 * @param: @param
	 *             checkedInfo（点不通过时才需要这个）
	 * @param: @param
	 *             re
	 */
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

	/**
	 * 
	 * @Title: universityAdd
	 * @Description: 为用户添加一所学校
	 * @param: @param
	 *             name
	 * @param: @param
	 *             universityType
	 * @param: @param
	 *             universityNature
	 * @param: @param
	 *             categoryid
	 * @param: @param
	 *             legalPersonName
	 * @param: @param
	 *             legalPersonCard
	 * @param: @param
	 *             legalPersonPhone
	 * @param: @param
	 *             introduction
	 * @param: @param
	 *             userId
	 * @param: @param
	 *             address
	 * @param: @param
	 *             re
	 */
	@RequestMapping(value="universityAdd.do", method = RequestMethod.POST)
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
	/**
	 * 
	 * @Title: categoryList
	 * @Description: 查询学校的全部等级（kz_university_category）
	 * @param: @return
	 * @return: List<UniversityCategory> 返回值类型
	 */
	@RequestMapping(value="categoryList.do", method = RequestMethod.GET)
	@ResponseBody
	public List<UniversityCategory> categoryList() {
		List<UniversityCategory> list = iUniversityService.categoryList();
		return list;
	}
	/**
	 * 
	 * @Title: productTO
	 * @Description: 从前台跳到普通用户后台
	 * @param: @param
	 *             session
	 * @param: @return
	 * @return: String 返回值类型
	 */
	@RequestMapping(value = "toProduct.do", method = RequestMethod.GET)
	public String productTO(HttpSession session) {
		// 由于页面加载时级需要查询状态所以就在在里做查询了
		User u = (User) session.getAttribute(Const.CURRENT_USER);
		University un = new University();
		if(u!=null){
			long userid = u.getUuid();
			un.setUserId((int) userid);
		}
		List<University> result = iUniversityService.schoolByUserIdList(un);
		if(result.size()>0){
			session.setAttribute("publicStatus", result.get(0).getPublishStatus());
			session.setAttribute("User_list", result.get(0));
		}else{
			session.setAttribute("User_list",un);
			session.setAttribute("publicStatus",un);
		}
		return "product";
	}


	/**
	 * 
	 * @Title: SchoolIndex
	 * @Description: 学校首页 （也是从前台跳到管理员后台）
	 * @param: @return
	 * @return: String 返回值类型
	 */
	@RequestMapping(value = "index.do", method = RequestMethod.GET)
	public String SchoolIndex() {
		return "schoollist";
	}
	/**
	 * 
	 * @Title: SchoolAudit
	 * @Description: 跳转到审查学校
	 * @param: @return
	 * @return: String 返回值类型
	 */
	@RequestMapping(value = "toSchoolAudit.do", method = RequestMethod.GET)
	public String SchoolAudit() {
		return "school_audit";
	}
	/**
	 * 
	 * @Title: SchoolNopass
	 * @Description: 跳转到未通过学校
	 * @param: @return
	 * @return: String 返回值类型
	 */
	@RequestMapping(value = "toSchoolNopass.do", method = RequestMethod.GET)
	public String SchoolNopass() {
		return "nopass_schools";
	}


	/**
	 * 
	 * @Title: listKeyPublishStatus
	 * @Description: 分页查询学校信息
	 * @param: @param
	 *             pageSiz
	 * @param: @param
	 *             pageNum
	 *             
	 * @param: @param
	 *             provid
	 * @param: @param
	 *             cityid
	 * @param: @param
	 *             areaid
	 * @param: @param
	 *             search_key
	 * @param: @return
	 * @return: ServerResponse<PageInfo> 返回值类型
	 */
	@RequestMapping(value="schoolListPageWithConditions.do", method = RequestMethod.POST)
	@ResponseBody
	public ServerResponse<PageInfo> listKeyPublishStatus(UniversityQuery qu) {
		// 按条件分页查询
		PageInfo pageInfo = iUniversityService.listKeyPublishStatus(qu);
		return ServerResponse.createBySuccess("查询成功", pageInfo);
	}
	
	/**
	 * 
	 * @Title: dimListPage
	 * @Description: 分页查询学校信息
	 * @param: @param
	 *             pageSiz
	 * @param: @param
	 *             pageNum
	 *             
	 * @param: @param
	 *             provid
	 * @param: @param
	 *             cityid
	 * @param: @param
	 *             areaid
	 * @param: @param
	 *             search_key
	 * @param: @param
	 *             resp
	 * @param: @return
	 * @return: ServerResponse 返回值类型
	 */
	@RequestMapping(value="dimListPage.do", method = RequestMethod.GET)
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

	/**
	 * 
	 * @Title: list
	 * @Description: 分页查询学校信息
	 * @param: @param
	 *             pageSiz
	 * @param: @param
	 *             pageNum
	 * @param: @param
	 *             session
	 * @param: @return
	 * @return: ServerResponse<PageInfo> 返回值类型
	 */
	@RequestMapping("schoolList.do")
	@ResponseBody
	public ServerResponse<PageInfo> list(UniversityQuery uq,HttpSession session) {
		/*User user = (User) session.getAttribute(Const.CURRENT_USER);
		if (user == null) {
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录,请登录管理员");
		}*/
		PageInfo pageInfo = iUniversityService.getByConditionPage(uq);
		// 页面显示数据
		return ServerResponse.createBySuccess("查询成功", pageInfo);
	}
	

	/**
	 * 
	 * @Title: schoolByIsNotHotList
	 * @Description: 查询学校是否热门 
	 * @param: @param
	 *             pageSiz
	 * @param: @param
	 *             pageNum
	 * @param: @param
	 *             isHot
	 * @param: @return
	 * @return: ServerResponse<University> 返回值类型
	 */
	@RequestMapping(value="schoolByIsNotHotList.do", method = RequestMethod.POST)
	@ResponseBody
	public PageInfo<University> schoolByIsNotHotList(UniversityQuery hq){
		PageInfo<University> hotList = iUniversityService.schoolByIsNotHotList(hq);
		return hotList;
	}
	
	/**
	 * 
	 * @Title: university_detail
	 * @Description: 按照universityId 分页查询学校信息
	 * @param: @param
	 *             pageSiz
	 * @param: @param
	 *             pageNum
	 * @param: @param
	 *             universityId
	 * @param: @param
	 *             session
	 * @param: @return
	 * @return: ServerResponse<University> 返回值类型
	 */
	@RequestMapping(value="university_detail.do", method = RequestMethod.GET)
	@ResponseBody
	public ServerResponse<University> list(HttpSession session ,Long universityId, int pageNum, int pageSize) {
		if (pageNum == 0) {
			pageNum = 1;
		}
		if (pageSize == 0) {
			pageSize = 8;
		}
		/*User user = (User) session.getAttribute(Const.CURRENT_USER);
		if (user == null) {
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录,请登录管理员");
		}*/
		// 3，根据学校的id查询该学校的所有专业信息
		University university = iUniversityService.selectMajorsPageById(universityId, pageNum, pageSize);

		// 页面显示数据
		return ServerResponse.createBySuccess("查询成功", university);
	}
	/**
	 * 
	 * @Title: schoolAddressList
	 * @Description: 按照用户id来查找该学校
	 * @param: @param
	 *             pageSiz
	 * @param: @param
	 *             pageNum
	 * @param: @param
	 *             schoolLongitude
	 * @param: @param
	 *             schoolLatitude
	 * @param: @return
	 * @return: ServerResponse 返回值类型
	 */
	@RequestMapping(value="schoolAddressList.do", method = RequestMethod.POST)
	@ResponseBody
	public PageInfo<University> schoolAddressList(UniversityQuery hq){
		PageInfo<University> hotList = iUniversityService.schoolAddressList(hq);
		return hotList;
	}
	/**
	 * 
	 * @Title: save
	 * @Description: 管理员学校的图片上传
	 * @param: @param
	 *             session
	 * @param: @param
	 *             upload_file
	 * @param: @param
	 *             request
	 * @param: @return
	 * @return: ServerResponse 返回值类型
	 */
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
	/**
	 * 
	 * @Title: save
	 * @Description: 学校的图片上传
	 * @param: @param
	 *             session
	 * @param: @param
	 *             upload_file
	 * @param: @param
	 *             request
	 * @param: @return
	 * @return: ServerResponse 返回值类型
	 */
	@RequestMapping("save1.do")
	@ResponseBody
	public ServerResponse save1(HttpSession session,
			@RequestParam(value = "upload_file", required = false) MultipartFile file, HttpServletRequest request) {
		User user = (User) session.getAttribute(Const.CURRENT_USER);
		if (user == null) {
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录,请登录管理员");
		}
			String path = request.getSession().getServletContext().getRealPath("upload");
			String targetFileName = iFileService.upload(file, path);
			String url = PropertiesUtil.getProperty("ftp.server.http.prefix") + targetFileName;

			Map fileMap = Maps.newHashMap();
			fileMap.put("uri", targetFileName);
			fileMap.put("url", url);
			return ServerResponse.createBySuccess(fileMap);
	}
}

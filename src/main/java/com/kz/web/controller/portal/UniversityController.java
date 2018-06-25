package com.kz.web.controller.portal;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
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
import com.kz.po.Address;
import com.kz.po.MajorCategoryQuery;
import com.kz.po.University;
import com.kz.po.UniversityCategory;
import com.kz.po.UniversityDynamic;
import com.kz.po.UniversityQuery;
import com.kz.po.User;
import com.kz.service.IFileService;
import com.kz.service.IUniversityService;
import com.kz.service.IUserService;
import com.kz.utils.PropertiesUtil;

import net.sf.json.JSONObject;

import java.lang.reflect.Field;


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
	 * @Title: selectByMajorCategoryId
	 * @Description: 按照专业类别来查找学校
	 * @param: @param
	 *             session
	 * @param: @return
	 * @return: String 返回值类型
	 */
	@RequestMapping(value="selectByMajorCategoryId.do")
	@ResponseBody
	public ServerResponse<PageInfo> selectByMajorCategoryId(UniversityQuery qu) {
		PageInfo pageInfo = iUniversityService.selectByMajorCategoryId(qu);
		return ServerResponse.createBySuccess("查询成功", pageInfo);
	}
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
	public void schoolByUserIdUpdate(UniversityQuery qu, HttpServletResponse response,HttpServletRequest request,HttpSession session) {
		Long result = iUniversityService.userInfoSchool(qu);
		//用户更改完成后session里面也需要更改
		User u = (User) session.getAttribute(Const.CURRENT_USER);
		University un = new University();
		if(u!=null){
			long userid = u.getUuid();
			un.setUserId((int) userid);
		}
		List<University> resultUniversity = iUniversityService.schoolByUserIdList(un);
		if(resultUniversity.size()>0){
			session.setAttribute("publicStatus", resultUniversity.get(0).getPublishStatus());
			session.setAttribute("User_list", resultUniversity.get(0));
		}
		try {
//			response.sendRedirect("/kzych/user/userinfoTo.do");
			if(result==2L){
				response.sendRedirect("/user/toUserInfo.do");
			}else{
				response.sendRedirect("/error.do");
			}
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
	@RequestMapping(value="schoolByUserIdList.do")
	@ResponseBody
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
	@RequestMapping(value="updatePublicStatus.do", method = RequestMethod.POST)
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
	public void universityAdd(Address address,University m, HttpServletResponse re) {
		PrintWriter out = null;
		try {
			out = re.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Long long1 = iUniversityService.prodectAdd(m, address);
		if (long1== 2L) {
			out.print("请求成功");
		} else {
			out.print("请求失败");
		}
	}
	
	/**
	 * 
	 * @Title: categoryList
	 * @Description: 查询学校的全部等级（categoryList）
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
		return "/admin/product";
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
		return "/admin/schoollist";
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
		return "/admin/school_audit";
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
		return "/admin/nopass_schools";
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
	@RequestMapping("schoolListPageWithConditions.do")
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
	@RequestMapping(value="dimListPage.do")
	@ResponseBody
	public PageInfo dimListPage(HttpServletRequest req,HttpServletResponse resp, UniversityQuery qu) {
		// ajax 按地址分页

		// 解决乱码问题
		String method = req.getMethod();
		if(method.equals("GET")){
			String provid = qu.getProvice();
			String cityid = qu.getCity();
			String areaid = qu.getCounty();
			String search_key = qu.getAddrdetail();
			try {
				if(provid!=null){
					provid = new String(provid.getBytes("iso-8859-1"), "UTF-8");
					qu.setProvice(provid);
				}
				if(cityid!=null){
					cityid = new String(cityid.getBytes("iso-8859-1"), "UTF-8");
					qu.setCity(cityid);
				}
				if(areaid!=null){
					areaid = new String(areaid.getBytes("iso-8859-1"), "UTF-8");
					qu.setCounty(areaid);
				}
				if(search_key!=null){
					search_key = new String(search_key.getBytes("iso-8859-1"), "UTF-8");
					qu.setAddrdetail(search_key);
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		@SuppressWarnings("rawtypes")
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
	public ServerResponse<PageInfo<University>> list(UniversityQuery uq,HttpSession session,HttpServletRequest re) {
		/*User user = (User) session.getAttribute(Const.CURRENT_USER);
		if (user == null) {
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录,请登录管理员");
		}*/
		String method = re.getMethod();
		if(method.equals("GET")){
			String provid = uq.getProvice();
			String cityid = uq.getCity();
			String areaid = uq.getCounty();
			String search_key = uq.getAddrdetail();
			try {
				if(provid!=null){
					provid = new String(provid.getBytes("iso-8859-1"), "UTF-8");
					uq.setProvice(provid);
				}
				if(cityid!=null){
					cityid = new String(cityid.getBytes("iso-8859-1"), "UTF-8");
					uq.setCity(cityid);
				}
				if(areaid!=null){
					areaid = new String(areaid.getBytes("iso-8859-1"), "UTF-8");
					uq.setCounty(areaid);
				}
				if(search_key!=null){
					search_key = new String(search_key.getBytes("iso-8859-1"), "UTF-8");
					uq.setAddrdetail(search_key);
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		PageInfo<University> pageInfo = iUniversityService.getByConditionPage(uq);
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
	@RequestMapping(value="schoolByIsNotHotList.do")
	@ResponseBody
	public PageInfo<University> schoolByIsNotHotList(UniversityQuery hq){
		PageInfo<University> hotList = iUniversityService.schoolByIsNotHotList(hq);
		return hotList;
	}
	
	/**
	 * 
	 * @Title: university_detail
	 * @Description: 按照universityId 分页查询学校专业
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
	@RequestMapping(value="universityPageDetail.do", method = RequestMethod.GET)
	@ResponseBody//在一些页面中这个方法还需要改 university_detail
	public ServerResponse list(HttpSession session ,UniversityQuery qu) {
		/*User user = (User) session.getAttribute(Const.CURRENT_USER);
		if (user == null) { 
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录,请登录管理员");
		}*/
		// 3，根据学校的id查询该学校的所有专业信息
		List<University> university = iUniversityService.selectMajorsPageById(qu);
		
		// 页面显示数据
		return ServerResponse.createBySuccess("查询成功", university);
	}
	/**
	 * 
	 * @Title: schoolAddressList
	 * @Description: 按照地理位置来查找
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
	
	/**
	 * 
	 * @Title: updateByKeyId
	 * @Description: 为用户添加一所学校
	 * @param: @param
	 *             id
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
	@RequestMapping(value="updateByKeyId.do")
	public void updateByKeyId(UniversityQuery qu, HttpServletResponse re) {
		PrintWriter out = null;
		try {
			out = re.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Long long1 = iUniversityService.prodectUpdate(qu);
		if (long1 > 1L) {
			out.print("请求成功");
		} else {
			out.print("请求失败");
		}
	}
	
	//还没有写Controller接口
	@RequestMapping(value="UpdateTelephone.do",method = RequestMethod.GET)
	public void UpdateTelephone(University u, HttpServletResponse re) {
		PrintWriter out = null;
		try {
			out = re.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Long updateByTelephone = iUniversityService.updateByTelephone(u);
		if(updateByTelephone>=1L){
			out.println("成功");
		}else{
			out.print("失败");
		}
	}
	
	
	//招生简章的数据返回 Enrollment Guide
	@RequestMapping(value="/selectByUniversityId.do")
	@ResponseBody
	public JSONObject schoolByProfession(int universityId,HttpSession session,HttpServletResponse response){
		StringBuffer json=new StringBuffer("{\"code\": 0,\"msg\": \"\",\"count\": 2,\"data\": [");
		List<UniversityDynamic> list = iUniversityService.selectByUniversityId(universityId);
		for(int i=0;i<list.size();i++){
			if(i==0){
				json.append("{");
			}
			if(i!=list.size()-1){
				json.append("\"id\":"+"\""+list.get(i).getRsId()+"\","+"\"datetime\":"+"\""+list.get(i).getRsDatetime()+"\",\"name\":\""+list.get(i).getRsTitle()+"\"},{");
			}else{
				json.append("\"id\":"+"\""+list.get(i).getRsId()+"\","+"\"datetime\":"+"\""+list.get(i).getRsDatetime()+"\",\"name\":\""+list.get(i).getRsTitle()+"\"}");
			}
		}
		json.append("]}");
		JSONObject json_test = JSONObject.fromObject(json.toString());
		return json_test;
	}
	
	
	//====*** 热门专业
	/*一 《专业分类    
	 * http://localhost:8080/kzych/major/majorCategoryList.do
	 *二 《通过专业来查找专业列表 
	 *http://localhost:8080/kzych/major/list.do?majorCategoryId=1
	 *三 《通过专业列表来查找学校
	 *http://localhost:8080/kzych/major/major_university_list.do?majorId=1
	 *四 《通过学校id查找学校  
	 *http://localhost:8080/kzych/university/schollByIntroduceInfo.do?universityId=71&majorId=1
	 **/
	
	
	//四 《通过学校id查找学校
	@RequestMapping(value="university_major_detail.do") 
	@ResponseBody 
	public ServerResponse<PageInfo> schoolByIntroduceInfo(UniversityQuery qu) {
		PageInfo pageInfo = iUniversityService.schoolByIntroduceInfo(qu);
		return ServerResponse.createBySuccess("查询成功", pageInfo);
	}
	
	//===**附件学校
	//一，按照学校类别来查找学校
	//http://localhost:8080/kzych/university/schollByTypeList.do?categoryId=2
	//二，然后通过学校id来查找 该学校所有专业  和 学校信息（学校视频及学校图片）以及学校招生动态
	
	/*二（1）通过id查找学校以及地址
	 * http://localhost:8080/kzych/university/schollAndAddressList.do?universityId=2
	 *二（2）通过学校id查找该学校所有专业
	 *http://localhost:8080/kzych/university/schollByMajor.do?universityId=71
	 *二（3）通过学校id查找该学校的概况
	 *http://localhost:8080/kzych/university/schollByIntroduce.do?universityId=71
	 *二（4）通过学校id查找该学校的动态
	 *http://localhost:8080/kzych/university/schollByRecruit.do?universityId=71
	 * */
	
	//一，按照学校类别来查找学校
	@RequestMapping(value="schollByTypeList.do")  
	@ResponseBody 
	public ServerResponse<PageInfo> schollByTypeList(UniversityQuery qu) {
		PageInfo pageInfo = iUniversityService.schollByTypeList(qu);
		return ServerResponse.createBySuccess("查询成功", pageInfo);
	}
	
	//二（1）通过id查找学校以及地址
	@RequestMapping(value="university_detail.do") 
	@ResponseBody 
	public ServerResponse<PageInfo> universityDetail(UniversityQuery qu) {
		PageInfo pageInfo = iUniversityService.universityDetail(qu);
		return ServerResponse.createBySuccess("查询成功", pageInfo);
	}
	 //二（2）通过学校id查找该学校所有专业
	@RequestMapping(value="university_detail_Major.do") 
	@ResponseBody 
	public ServerResponse<PageInfo> schollByMajor(UniversityQuery qu) {
		PageInfo pageInfo = iUniversityService.schollByMajor(qu);
		return ServerResponse.createBySuccess("查询成功", pageInfo);
	}
	 
	 //*二（3）通过学校id查找该学校的概况
	@RequestMapping(value="university_detail_Introduce.do") 
	@ResponseBody 
	public ServerResponse<PageInfo> schollByIntroduce(UniversityQuery qu) {
		PageInfo pageInfo = iUniversityService.schollByIntroduce(qu);
		return ServerResponse.createBySuccess("查询成功", pageInfo);
	}
	 //*二（4）通过学校id查找该学校的动态 
	@RequestMapping(value="university_detail_dynamic.do") 
	@ResponseBody 
	public ServerResponse<PageInfo> schollByRecruit(UniversityQuery qu) {
		PageInfo pageInfo = iUniversityService.schollByRecruit(qu);
		return ServerResponse.createBySuccess("查询成功", pageInfo);
	}
//下面是還沒寫controller接口的 
	@RequestMapping(value="mySchoolMajorInfo.do") 
	@ResponseBody 
	public JSONObject mySchoolMajorInfo(UniversityQuery qu) {
		StringBuffer json=new StringBuffer("{\"code\": 0,\"msg\": \"\",\"count\": 2,\"data\": [");
		List<University> schoolResult = iUniversityService.mySchoolMajorInfo(qu);
		for(int i=0;i<schoolResult.size();i++){
			for(int j=0;j<schoolResult.get(i).getMajors().size();j++){
				json.append("{\"id\":"+schoolResult.get(i).getMajors().get(j).getId()+",\"level\":\""+schoolResult.get(i).getUniversityCategory().getCategoryName()+"\",");
				json.append("\"name\":\""+schoolResult.get(i).getMajors().get(j).getName()+"\",");
				if(j!=schoolResult.get(i).getMajors().size()-1){
					json.append("\"tuition\":\""+schoolResult.get(i).getMajors().get(j).getMajorCode()+"\"},");
				}else{
					json.append("\"tuition\":\""+schoolResult.get(i).getMajors().get(j).getMajorCode()+"\"}");
				}
			}
		}
		json.append("]}");
		JSONObject json_test = JSONObject.fromObject(json.toString());
		return json_test;
	}
	/*9，获取热门专业列表
	http://www.iychua.com:8080/major/pop_major_list?pageNum=1&pageSize=10

	10，获取热门学校列表
	http://www.iychua.com:8080/university/pop_university_list?pageNum=1&pageSize=10
	 */
	@RequestMapping("pop_university_list.do")
	@ResponseBody
	public ServerResponse<PageInfo<University>> popUniversityList(UniversityQuery qu){
		PageInfo<University> universityList= iUniversityService.myUniversityHost(qu);
		return ServerResponse.createBySuccess("查询成功",universityList);
	}
}


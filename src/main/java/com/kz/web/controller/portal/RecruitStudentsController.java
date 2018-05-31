package com.kz.web.controller.portal;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kz.core.common.Const;
import com.kz.po.RecruitStudents;
import com.kz.po.University;
import com.kz.po.User;
import com.kz.service.IRecruitStudents;
import com.kz.service.IUniversityService;

import net.sf.json.JSONObject;


@Controller
@RequestMapping("/recruit/")
public class RecruitStudentsController {
	@Autowired
	private IUniversityService universityService;
	@Autowired
	private IRecruitStudents recruitStudents;
	
	/**
	 * @Title: selectByMajorCategoryId
	 * @Description: 按照专业类别来查找学校
	 * @param: @param
	 *             session
	 * @param: @return
	 * @return: String 返回值类型
	 */
	/*@RequestMapping(value="selectByMajorCategoryId.do")
	@ResponseBody
	public ServerResponse<PageInfo> selectByMajorCategoryId(UniversityQuery qu) {
		PageInfo pageInfo = iUniversityService.selectByMajorCategoryId(qu);
		return ServerResponse.createBySuccess("查询成功", pageInfo);
	}*/
	//报名管理
	@RequestMapping(value="/enrollManager.do")
	public String toEnrollManager(){
		return "/admin/enroll_manager";
	}
	//招生首页
	@RequestMapping(value="/mySchool.do")
	public String toMySchool(HttpSession session,HttpServletResponse response){
		User user=(User)session.getAttribute(Const.CURRENT_USER);
		if(user==null){//如果为空就跳往登入页面
			try {
				response.sendRedirect("/front/login.do");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		University university=new University();
		//转类型
		long userid = user.getUuid();
		university.setUserId((int) userid);
		List<University> byUserIdList = universityService.schoolByUserIdList(university);
		session.setAttribute("schoolInfo", byUserIdList.get(0));
		return "/admin/my_school";
	}
	//招生简章的数据返回 Enrollment Guide
	@RequestMapping(value="/selectByUniversityId.do")
	@ResponseBody
	public JSONObject selectByUniversityId(int universityId,HttpSession session,HttpServletResponse response){
		StringBuffer json=new StringBuffer("{\"code\": 0,\"msg\": \"\",\"count\": 2,\"data\": [");
		List<RecruitStudents> list = recruitStudents.selectByUniversityId(universityId);
		for(int i=0;i<list.size();i++){
			if(i==0){
				json.append("{");
			}
			if(i!=list.size()-1){
				json.append("\"id\":"+"\""+list.get(i).getRsId()+"\","+"\"datetime\":"+"\""+formattingDate(list.get(i).getRsDatetime())+"\",\"name\":\""+list.get(i).getRsTitle()+"\"},{");
			}else{
				json.append("\"id\":"+"\""+list.get(i).getRsId()+"\","+"\"datetime\":"+"\""+formattingDate(list.get(i).getRsDatetime())+"\",\"name\":\""+list.get(i).getRsTitle()+"\"}]}");
			}
		}
		if(list.size()==0){
			json.append("]}");
		}
		JSONObject json_test = JSONObject.fromObject(json.toString());
		return json_test;
	}
	//添加
	@RequestMapping(value="/addRS.do")
	public void addRS(RecruitStudents rs,HttpServletResponse re){
		rs.setRsDatetime(new Date());
		Long long1 = recruitStudents.addSelective(rs);
		PrintWriter out = null;
		try {
			out = re.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(long1>=1L){
			out.print("添加成功");
		}else{
			out.print("添加成功");
		}
	}
	//添加
	@RequestMapping(value="/delRS.do")
	public void delRS(Long rsId,HttpServletResponse re){
		Long deleteByPrimaryKey = recruitStudents.deleteByPrimaryKey(rsId);
		
		PrintWriter out = null;
		try {
			out = re.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(deleteByPrimaryKey>=1L){
			out.print("删除成功");
		}else{
			out.print("删除成功");
		}
	}
	
	public String formattingDate(Date date){
		Date nowTime=new Date(); 
		SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd"); 
		return time.format(nowTime);
	}
	
}


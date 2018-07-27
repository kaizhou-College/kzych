package com.kz.web.controller.portal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.kz.core.common.ServerResponse;
import com.kz.dao.MajorCategoryMapper;
import com.kz.po.Major;
import com.kz.po.MajorCategory;
import com.kz.po.MajorCategoryQuery;
import com.kz.po.MajorQuery;
import com.kz.po.MajorUniversity;
import com.kz.po.UniversityQuery;
import com.kz.service.IMajorService;
import com.kz.service.IUniversityService;

@Controller
@RequestMapping("/major/")
public class MajorController {

	@Autowired
	private IMajorService iMajorService;
	
	@Autowired
	private IUniversityService iUniversityService;
	
	/**
	 * 
	 * @Title: majorCategoryList
	 * @Description: 分页查询专业类别
	 * @param: @param
	 *             pageSiz
	 * @param: @param
	 *             pageNum
	 * @param: @return
	 * @return: ServerResponse<PageInfo> 返回值类型
	 */
	@RequestMapping(value="major_category_list.do", method = RequestMethod.GET) //原来majorCategorylist
	@ResponseBody
	public ServerResponse majorCategorylist(MajorCategoryQuery qm){
		PageInfo<MajorCategory> pageInfo = iMajorService.majorCategorylist(qm);
		return ServerResponse.createBySuccess("查询成功", pageInfo);
	}
	
	
	
	/**
	 * 
	 * @Title: list
	 * @Description: 分页查询专业信息
	 * @param: @param
	 *             pageSiz
	 * @param: @param
	 *             pageNum
	 * @param: @return
	 * @return: ServerResponse<PageInfo> 返回值类型
	 */
	@RequestMapping(value="major_list.do") //原来list
	@ResponseBody
	public ServerResponse<PageInfo> list(MajorQuery mq){
		PageInfo pageInfo = iMajorService.getByConditionPage(mq);
		// 页面显示数据
		return ServerResponse.createBySuccess("查询成功", pageInfo);
	}

	/**
	 * 
	 * @Title: findByUniversityId
	 * @Description: 根据学校id和专业id查询专业信息
	 * @param: @param
	 *             universityId
	 * @param: @param
	 *             majorId
	 * @param: @return
	 * @return: ServerResponse<MajorUniversity> 返回值类型
	 */
	@RequestMapping(value="major_by_university.do", method = RequestMethod.POST)
	@ResponseBody
	public ServerResponse<MajorUniversity> findByUniversityId(int universityId, int majorId) {
		MajorUniversity majorUniversity = iMajorService.findByUniversityId(universityId, majorId);
		if (majorUniversity == null) {
			ServerResponse.createByErrorMessage("本校还未开此专业！！");
		}
		return ServerResponse.createBySuccess("查询成功！", majorUniversity);
	}
	
	//三 《通过专业列表id来查找学校   
	@RequestMapping(value="major_university_list.do")  //原来selectByMajorId
	@ResponseBody 
	public ServerResponse<PageInfo> selectByMajorId(UniversityQuery qu) {
		PageInfo pageInfo = iUniversityService.selectByMajorId(qu);
		return ServerResponse.createBySuccess("查询成功", pageInfo);
	}
	
	@RequestMapping(value="pop_major_list.do")
	@ResponseBody
	public ServerResponse<PageInfo> myMajorHot(MajorQuery qm){
		PageInfo majorInfo=iMajorService.myMajorHot(qm);
		return ServerResponse.createBySuccess("查询成功",majorInfo);
	}
	
	@RequestMapping(value="search.do")
	@ResponseBody
	public ServerResponse<PageInfo> search(@RequestBody MajorQuery qm){
		PageInfo majorUniversity=iMajorService.majorAndUniversityDim(qm);
		return ServerResponse.createBySuccess("查成功", majorUniversity);
	}
	
	//按照majorCategoryId(专业类别id)来查找专业
	@RequestMapping(value="majorTyleIdSearch.do")
	@ResponseBody
	public ServerResponse<PageInfo> majorTyleIdSearch(MajorQuery qm){
		PageInfo majorUniversity=iMajorService.majorTyleIdSearch(qm);
		return ServerResponse.createBySuccess("查成功", majorUniversity);
	}
}

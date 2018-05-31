package com.kz.web.controller.portal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
import com.kz.service.IMajorService;

@Controller
@RequestMapping("/major/")
public class MajorController {

	@Autowired
	private IMajorService iMajorService;
	
	
	
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
	@RequestMapping(value="majorCategoryList.do", method = RequestMethod.GET)
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
	@RequestMapping(value="list.do")
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
	

	
	
}

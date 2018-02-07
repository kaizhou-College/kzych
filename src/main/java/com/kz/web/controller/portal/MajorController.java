package com.kz.web.controller.portal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kz.core.common.Const;
import com.kz.core.common.ServerResponse;
import com.kz.po.Major;
import com.kz.po.MajorUniversity;
import com.kz.service.IMajorService;

@Controller
@RequestMapping("/major/")
public class MajorController {
	
	@Autowired
	private IMajorService iMajorService;
	@RequestMapping("list.do")
	@ResponseBody
	public ServerResponse<Major> list(){
		return null;
	}
	
	@RequestMapping("major_by_university.do")
	@ResponseBody
	public ServerResponse<MajorUniversity> findByUniversityId(int universityId,int majorId){
		MajorUniversity majorUniversity = iMajorService.findByUniversityId(universityId,majorId);
		if(majorUniversity==null){
			ServerResponse.createByErrorMessage("本校还未开此专业！！");
		}
		
		return ServerResponse.createBySuccess("查询成功！", majorUniversity);
	}
	
	
}

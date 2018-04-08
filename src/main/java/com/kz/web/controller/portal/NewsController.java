package com.kz.web.controller.portal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.kz.core.common.ServerResponse;
import com.kz.po.News;
import com.kz.po.NewsQuery;
import com.kz.service.INewsService;

@Controller
@RequestMapping("/news/")
public class NewsController {
	
	@Autowired
	private INewsService  iNewsService;
	
	
	//一开始的分页
	@RequestMapping("list.do")
	@ResponseBody
	public ServerResponse<PageInfo> list(NewsQuery uq) {
		PageInfo pageInfo = iNewsService.getByConditionPage(uq);
		// 页面显示数据
		if(pageInfo.getList().size()>0){
			return ServerResponse.createBySuccess("查询成功", pageInfo);
		}else{
			return ServerResponse.createBySuccess("查询失败", pageInfo);
		}
		
	}
	//单个查询（按照id）   点击进入显示单个详细详细
	@RequestMapping("accordingKeyList.do")
	@ResponseBody
	public ServerResponse<News> listKey(News co){
		News content = iNewsService.selectByPrimaryKey(co.getId());
		if(content!=null){
			return ServerResponse.createBySuccess("单个查询成功",content);
		}else{
			return ServerResponse.createBySuccess("单个查询失败没有该id",content);
		}
		
	}
	
	// 按照标题模糊查询  并且分页
	@RequestMapping("dimListPage.do")
	@ResponseBody
	public ServerResponse dimListPage(NewsQuery co){
		List contentPage = iNewsService.dimContentPage(co);
		return ServerResponse.createBySuccess("模糊询成功",contentPage);
	}
	
	//点赞  按照id 添加一个赞
	@RequestMapping("hit.do")
	@ResponseBody
	public ServerResponse<PageInfo> hit(News co){
		Long whileKeyUpdateHit = iNewsService.whileKeyUpdateHit(co);
		if(whileKeyUpdateHit>0){
			return ServerResponse.createBySuccessMessage("点赞成功成功");
		}else{
			return ServerResponse.createBySuccessMessage("点赞失败");
		}
		
	}
}

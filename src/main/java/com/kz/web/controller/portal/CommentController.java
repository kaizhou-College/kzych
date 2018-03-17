package com.kz.web.controller.portal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.kz.core.common.Const;
import com.kz.core.common.ServerResponse;
import com.kz.po.CommentWithBLOBs;
import com.kz.po.User;
import com.kz.service.ICommentService;

@Controller
@RequestMapping("/comment/")
public class CommentController {
	@Autowired
	private ICommentService iCommentService;
	
	@RequestMapping("create.do")
	@ResponseBody
	public ServerResponse<PageInfo> commentAdd(CommentWithBLOBs co,HttpSession session){
		User attribute = (User)session.getAttribute(Const.CURRENT_USER);
		co.setNickName(attribute.getUsername());
		Long addComment = iCommentService.accordingNewsIdAddComment(co);
		if(addComment>0){
			return ServerResponse.createBySuccessMessage("评论成功");
		}else{
			return ServerResponse.createBySuccessMessage("评论失败");
		}
	}
}

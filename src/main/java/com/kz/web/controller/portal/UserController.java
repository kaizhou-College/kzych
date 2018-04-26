package com.kz.web.controller.portal;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.collect.Maps;
import com.kz.core.common.Const;
import com.kz.core.common.ResponseCode;
import com.kz.core.common.ServerResponse;
import com.kz.po.User;
import com.kz.service.IFileService;
import com.kz.service.IUserService;
import com.kz.utils.PropertiesUtil;

/**
 * @Title: UserController.java
 * @Package com.kz.web.controller.portal
 * @Description: 用户cotroller
 * @author 凯舟.陈超
 * @date 2018年1月4日 下午10:54:46
 * @version V1.0
 */

@Controller
@RequestMapping("/user/")
public class UserController {
	@Autowired
	private IUserService iUserService;
	@Autowired
	private IFileService iFileService;
	
	//用户注册时跳往用户设置权限页面
	@RequestMapping(value = "toUserType.do", method = RequestMethod.POST)
	public void tOUserType(HttpSession session,HttpServletResponse response,User user) {
		session.setAttribute("userInfo",user);
		try {
			response.sendRedirect("/front/usertype.do");
//			response.sendRedirect("/kzych/front/usertype.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @Title: userinfoByKeyUpdate
	 * @Description: 根据id修改用户信息
	 * @param: @param
	 *             uuid
	 * @param: @param
	 *             username
	 * @param: @param
	 *             realName
	 * @param: @param
	 *             cellphone
	 * @param: @param
	 *             idcard
	 * @param: @param
	 *             school
	 * @param: @param
	 *             originPlace
	 *             
	 * @return: 没有返回值
	 */
	@RequestMapping(value = "userinfoByKeyUpdate.do", method = RequestMethod.POST)
	public void userinfoByKeyUpdate(User u, HttpServletResponse response,HttpSession session) {
		Long long1 = iUserService.updateByKeyInfo(u);
		try {
			if (long1 == 1l) {
				response.sendRedirect("/user/toUserInfo.do");
				//response.sendRedirect("/kzych/user/userinfoTo.do");
			} else {
				response.sendRedirect("/user/error.do");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @Title: login
	 * @Description: 跳往用户信息
	 * @param: @param
	 *             session
	 * @return: String 返回值类型
	 */
	@RequestMapping(value = "toUserInfo.do", method = RequestMethod.GET)
	public String toUserInfo(HttpSession session) {
		//由于在userinfo页面修改信息后session中的用户信息还没有更新Const.CURRENT_USER 所以在这里需要把session中的值更新成最新的
		User user=(User) session.getAttribute(Const.CURRENT_USER);
		ServerResponse<User> login = iUserService.getInformation(user.getUuid());
		session.setAttribute(Const.CURRENT_USER, login.getData());
		return "/admin/userinfo";
	}

	/**
	 * @Title: login
	 * @Description: 登陆
	 * @param: @param
	 *             username
	 * @param: @param
	 *             password
	 * @param: @param
	 *             session
	 * @param: @return
	 * @return: ServerResponse<User> 返回值类型
	 */
	@RequestMapping(value="login.do", method = RequestMethod.POST)
	@ResponseBody
	public ServerResponse<User> login(String username, String password, HttpSession session) {
		ServerResponse<User> response = iUserService.login(username, password);
		if (response.isSuccess()) {
			session.setAttribute(Const.CURRENT_USER, response.getData());
		}
		return response;
	}

	/**
	 * @Title: login
	 * @Description: 验证是否管理员
	 * @param: @param
	 *             username
	 * @param: @param
	 *             session
	 * @param: @return
	 * @return: ServerResponse<User> 返回值类型
	 */
	@RequestMapping(value="isNotAdministrator.do", method = RequestMethod.POST)
	@ResponseBody
	public ServerResponse<User> isNotAdministrator(String username, HttpSession session) {
		ServerResponse<User> response = iUserService.IsNotAdministrator(username);
		return response;
	}

	/**
	 * @Title: logout
	 * @Description: 退出
	 * @param: @param
	 *             session
	 * @param: @return
	 * @return: ServerResponse<String> 返回值类型
	 */

	@RequestMapping(value = "logout.do", method = RequestMethod.GET)
	@ResponseBody
	public ServerResponse<String> logout(HttpSession session) {
		session.removeAttribute(Const.CURRENT_USER);
		return ServerResponse.createBySuccessMessage("成功退出");
	}

	/**
	 * @Title: register
	 * @Description: 注册
	 * @param: @param
	 *             user
	 * @param: @return
	 * @return: ServerResponse<String> 返回值类型
	 */
	@RequestMapping(value = "register.do", method = RequestMethod.POST)
	@ResponseBody
	public ServerResponse<String> register(User user,HttpSession session) {
		//登入时的数据
		User u =(User) session.getAttribute("userInfo");
		if(u!=null){
			user.setUsername(u.getUsername());
			user.setPassword(u.getPassword());
			user.setCellphone(u.getCellphone());
		}
		//因为如果这个对象拿去添加完成后它的密码会被加密所有用这个变量先啦接受这个值
		String password = user.getPassword();
		//注册
		ServerResponse<String> register = iUserService.register(user);
		//注册之后就去获取该用户的信息
		ServerResponse<User> response = iUserService.login(user.getUsername(),password);
		session.setAttribute(Const.CURRENT_USER, response.getData());
		return register;
	}

	/**
	 * @Title: update_information
	 * @Description: 更新用户信息
	 * @param: @param
	 *             session
	 * @param: @param
	 *             user
	 * @param: @return
	 * @return: ServerResponse<User> 返回值类型
	 */
	@RequestMapping(value = "update_information.do", method = RequestMethod.POST)
	@ResponseBody
	public ServerResponse<User> update_information(HttpSession session, User user) {
		User currentUser = (User) session.getAttribute(Const.CURRENT_USER);
		if (currentUser == null) {
			return ServerResponse.createByErrorMessage("用户未登录");
		}
		user.setUuid(currentUser.getUuid());
		user.setUsername(currentUser.getUsername());
		ServerResponse<User> response = iUserService.updateInformation(user);
		if (response.isSuccess()) {
			response.getData().setUsername(currentUser.getUsername());
			session.setAttribute(Const.CURRENT_USER, response.getData());
		}
		return response;
	}

	/**
	 * @Title: get_information
	 * @Description:获取用户信息
	 * @param: @param
	 *             session
	 * @param: @return
	 * @return: ServerResponse<User> 返回值类型
	 */
	@RequestMapping(value = "get_information.do", method = RequestMethod.POST)
	@ResponseBody
	public ServerResponse<User> get_information(HttpSession session) {
		User currentUser = (User) session.getAttribute(Const.CURRENT_USER);
		if (currentUser == null) {
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "未登录,需要强制登录status=10");
		}
		return iUserService.getInformation(currentUser.getUuid());
	}
	/**
	 * 
	 * @Title: save
	 * @Description: 用户头像上传
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
			//判断用户是否登入
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

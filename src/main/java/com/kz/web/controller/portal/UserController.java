package com.kz.web.controller.portal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kz.core.common.Const;
import com.kz.core.common.ResponseCode;
import com.kz.core.common.ServerResponse;
import com.kz.po.User;
import com.kz.service.IUserService;
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
	/**
	 * @Title: login 
	 * @Description: 登陆
	 * @param: @param username
	 * @param: @param password
	 * @param: @param session
	 * @param: @return
	 * @return: ServerResponse<User> 返回值类型
	 */
	@RequestMapping("login.do")
	@ResponseBody
	public ServerResponse<User> login(String username,String password,HttpSession session){
		ServerResponse<User> response= iUserService.login(username,password);
		if(response.isSuccess()){
			session.setAttribute(Const.CURRENT_USER, response.getData());
		}
		return response;
	}
	/**
	 * @Title: logout 
	 * @Description: 退出 
	 * @param: @param session
	 * @param: @return
	 * @return: ServerResponse<String> 返回值类型
	 */
	
	@RequestMapping(value = "logout.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> logout(HttpSession session){
        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createBySuccessMessage("成功退出");
    }
	/**
	 * @Title: register 
	 * @Description: 注册
	 * @param: @param user
	 * @param: @return
	 * @return: ServerResponse<String> 返回值类型
	 */
    @RequestMapping(value = "register.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> register(User user){
        return iUserService.register(user);
    }
    /**
     * @Title: update_information 
     * @Description: 更新用户信息
     * @param: @param session
     * @param: @param user
     * @param: @return
     * @return: ServerResponse<User> 返回值类型
     */
    @RequestMapping(value = "update_information.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> update_information(HttpSession session,User user){
        User currentUser = (User)session.getAttribute(Const.CURRENT_USER);
        if(currentUser == null){
            return ServerResponse.createByErrorMessage("用户未登录");
        }
        user.setUuid(currentUser.getUuid());
        user.setUsername(currentUser.getUsername());
        ServerResponse<User> response = iUserService.updateInformation(user);
        if(response.isSuccess()){
            response.getData().setUsername(currentUser.getUsername());
            session.setAttribute(Const.CURRENT_USER,response.getData());
        }
        return response;
    }
    /**
     * @Title: get_information 
     * @Description:获取用户信息
     * @param: @param session
     * @param: @return
     * @return: ServerResponse<User> 返回值类型
     */
    @RequestMapping(value = "get_information.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> get_information(HttpSession session){
        User currentUser = (User)session.getAttribute(Const.CURRENT_USER);
        if(currentUser == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"未登录,需要强制登录status=10");
        }
        return iUserService.getInformation(currentUser.getUuid());
    }


}

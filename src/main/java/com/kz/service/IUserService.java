package com.kz.service;

import com.github.pagehelper.PageInfo;
import com.kz.core.common.ServerResponse;
import com.kz.core.service.IBaseService;
import com.kz.po.University;
import com.kz.po.User;
import com.kz.po.UserQuery;
import com.kz.po.WxBindInfo;
import com.kz.po.WxBindInfoQuery;

public interface IUserService extends IBaseService<User, UserQuery>{

	ServerResponse<WxBindInfo> login(WxBindInfoQuery wx);

	ServerResponse<String> register(User user);

	ServerResponse<User> updateInformation(User user);

	ServerResponse<User> getInformation(Long uuid);

	ServerResponse checkAdminRole(User user);
	
	ServerResponse<User> IsNotAdministrator(String username);
	
	Long updateByKeyInfo(User u);
	
	Long userInfoAdd(User u);

}

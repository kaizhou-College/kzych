package com.kz.service;

import com.kz.core.common.ServerResponse;
import com.kz.core.service.IBaseService;
import com.kz.po.User;
import com.kz.po.UserQuery;

public interface IUserService extends IBaseService<User, UserQuery>{

	ServerResponse<User> login(String username, String password);

	ServerResponse<String> register(User user);

	ServerResponse<User> updateInformation(User user);

	ServerResponse<User> getInformation(Long uuid);

}

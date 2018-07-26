package com.kz.service;

import com.kz.core.common.ServerResponse;
import com.kz.core.service.IBaseService;
import com.kz.po.User;
import com.kz.po.UserQuery;
import com.kz.po.WxBindInfo;
import com.kz.po.WxBindInfoQuery;

public interface IWxUserService  extends IBaseService<WxBindInfo,WxBindInfoQuery>{
	
	ServerResponse<WxBindInfo> login(WxBindInfoQuery wx);
	
	ServerResponse<String> register(WxBindInfo wx);
}

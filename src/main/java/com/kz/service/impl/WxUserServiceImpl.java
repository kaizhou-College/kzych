package com.kz.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageInfo;
import com.kz.core.common.Const;
import com.kz.core.common.ServerResponse;
import com.kz.core.service.BaseService;
import com.kz.dao.UserMapper;
import com.kz.dao.WxBindInfoMapper;
import com.kz.po.User;
import com.kz.po.UserQuery;
import com.kz.po.WxBindInfo;
import com.kz.po.WxBindInfoQuery;
import com.kz.service.IWxUserService;
import com.kz.utils.MD5Util;

@Service
@Transactional
public class WxUserServiceImpl  extends BaseService<WxBindInfo, WxBindInfoQuery>  implements IWxUserService {

	private WxBindInfoMapper wxUserMapper = null;
	
	@Autowired
	private void setDao(WxBindInfoMapper mapper) {
		this.wxUserMapper = mapper;
		super.setMapper(mapper);
	}
	
	@Override
	public ServerResponse<WxBindInfo> login(WxBindInfoQuery wx) {
		WxBindInfo wxUser = wxUserMapper.selectLogin(wx);
		if (wxUser == null) {
			return ServerResponse.createByErrorMessage("沒有该用戶");
		}
		return ServerResponse.createBySuccess("登陆成功！！", wxUser);
	}
	
	public ServerResponse<String> register(WxBindInfo wx) {
		//user.setUserType(Const.UserTYPE.TYPE_CUSTOMER);
		wx.setToken("暂时未设值");
		wx.setExpiresIn(10);
		wx.setDateline(1);
		Long resultCount = wxUserMapper.insertSelective(wx);
		if (resultCount == 0) {
			return ServerResponse.createByErrorMessage("注册失败");
		}
		return ServerResponse.createBySuccessMessage("注册成功");
	}
	

}

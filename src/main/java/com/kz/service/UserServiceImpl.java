package com.kz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kz.core.common.Const;
import com.kz.core.common.ServerResponse;
import com.kz.core.service.BaseService;
import com.kz.dao.UserMapper;
import com.kz.po.User;
import com.kz.po.UserQuery;
import com.kz.utils.MD5Util;

@Service
public class UserServiceImpl extends BaseService<User, UserQuery>implements IUserService {
	private UserMapper userMapper = null;

	@Autowired
	private void setDao(UserMapper mapper) {
		this.userMapper = mapper;
		super.setMapper(mapper);
	}

	@Override
	public ServerResponse<User> login(String username, String password) {
		int resultCount = userMapper.checkUsername(username);
		if (resultCount == 0) {
			ServerResponse.createByErrorMessage("用户不存在!");
		}
		String md5Password = MD5Util.MD5EncodeUtf8(password);
		User user = userMapper.selectLogin(username, md5Password);
		if (user == null) {
			return ServerResponse.createByErrorMessage("密码错误");
		}
		user.setPassword(org.apache.commons.lang3.StringUtils.EMPTY);
		return ServerResponse.createBySuccess("登陆成功！！", user);
	}

	@Override
	public ServerResponse<String> register(User user) {
		ServerResponse validResponse = this.checkValid(user.getUsername(), Const.USERNAME);
		if (!validResponse.isSuccess()) {
			return validResponse;
		}
		validResponse = this.checkValid(user.getIdcard(), Const.IDCARD);
		if (!validResponse.isSuccess()) {
			return validResponse;
		}
		user.setUserType(Const.UserTYPE.TYPE_CUSTOMER);
		// MD5加密
		user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));
		int resultCount = userMapper.insert(user);
		if (resultCount == 0) {
			return ServerResponse.createByErrorMessage("注册失败");
		}
		return ServerResponse.createBySuccessMessage("注册成功");
	}

	public ServerResponse<String> checkValid(String str, String type) {
		if (org.apache.commons.lang3.StringUtils.isNotBlank(type)) {
			// 开始校验
			if (Const.USERNAME.equals(type)) {
				int resultCount = userMapper.checkUsername(str);
				if (resultCount > 0) {
					return ServerResponse.createByErrorMessage("用户名已存在");
				}
			}
			if (Const.IDCARD.equals(type)) {
				int resultCount = userMapper.checkIdcard(str);
				if (resultCount > 0) {
					return ServerResponse.createByErrorMessage("身份证已存在");
				}
			}
		} else {
			return ServerResponse.createByErrorMessage("参数错误");
		}
		return ServerResponse.createBySuccessMessage("校验成功");
	}

	@Override
	public ServerResponse<User> updateInformation(User user) {
		// username是不能被更新的
		// email也要进行一个校验,校验新的email是不是已经存在,并且存在的email如果相同的话,不能是我们当前的这个用户的.
		int resultCount = userMapper.checkEmailByUserId(user.getIdcard(), user.getUuid());
		if (resultCount > 0) {
			return ServerResponse.createByErrorMessage("email已存在,请更换email再尝试更新");
		}
		User updateUser = new User();
		updateUser.setUuid(user.getUuid());
		updateUser.setSex(user.getSex());
		updateUser.setIdcard(user.getIdcard());
		updateUser.setCellphone(user.getCellphone());
		updateUser.setOriginPlace(user.getOriginPlace());
		updateUser.setSchool(user.getSchool());
		updateUser.setSignMessage(user.getSignMessage());
		updateUser.setLastLoginTime(user.getLastLoginTime());

		int updateCount = userMapper.updateByPrimaryKeySelective(updateUser);
		if (updateCount > 0) {
			return ServerResponse.createBySuccess("更新个人信息成功", updateUser);
		}
		return ServerResponse.createByErrorMessage("更新个人信息失败");
	}

	public ServerResponse<User> getInformation(Long uuid) {
		User user = userMapper.selectByPrimaryKey(uuid);
		if (user == null) {
			return ServerResponse.createByErrorMessage("找不到当前用户");
		}
		user.setPassword(org.apache.commons.lang3.StringUtils.EMPTY);
		return ServerResponse.createBySuccess(user);
	}

	/**
	 * 校验是否是管理员
	 * 
	 * @param user
	 * @return
	 */
	public ServerResponse checkAdminRole(User user) {
		if (user != null && user.getUserType().intValue() == Const.UserTYPE.TYPE_ADMIN) {
			return ServerResponse.createBySuccess();
		}
		return ServerResponse.createByError();
	}

}

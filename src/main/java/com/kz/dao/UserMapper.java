package com.kz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kz.core.dao.BaseMapper;
import com.kz.po.University;
import com.kz.po.User;
import com.kz.po.UserQuery;

public interface UserMapper extends BaseMapper<User,UserQuery>{
	User selectLogin(@Param("username")String username,@Param("password") String md5Password);

	int checkIdcard(String idcard);

	int checkEmailByUserId(@Param("idcard")String idcard, @Param("uuid")Long uuid);

	int checkUsername(String str);
	
	User selectAdministrator(String username);
	Long updateByKeyInfo(User u);
	Long insertSelectiveRegister(User u);

	Long userInfoAdd(User u);
	
	List<User> userByIdCardSelect(String idcard);
}
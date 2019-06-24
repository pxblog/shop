package com.shop.service;

import java.util.List;

import com.shop.entity.Page;
import com.shop.entity.UserInfo;

public interface UserService {
	public void insertUser(UserInfo userInfo);
	public int  userNameCheck(String userName);
	public UserInfo  checkUser(UserInfo userInfo);
	public List<UserInfo> getAllUser();
	public int getAllUserNum();
	public List<UserInfo> selectUserByPageNum(Page page);
	public UserInfo getUserByUserId(int id);
	public void updateUserById(UserInfo userInfo);
	public void deleteUserById(int id);
	
}

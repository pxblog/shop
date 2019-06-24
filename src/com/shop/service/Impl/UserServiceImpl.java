package com.shop.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.entity.Page;
import com.shop.entity.UserInfo;
import com.shop.mapper.UserInfoMapper;
import com.shop.service.UserService;

@Service("userSerVice")
public class UserServiceImpl implements UserService{
	@Resource(name="userInfoMapper")
	UserInfoMapper userInfo;
	
	@Override
	public void insertUser(UserInfo userInfo) {
		// TODO 自动生成的方法存根
		this.userInfo.insertUser(userInfo);
	}

	@Override
	public int userNameCheck(String userName) {
		// TODO 自动生成的方法存根
		return userInfo.checkExist(userName);
	}

	@Override
	public UserInfo checkUser(UserInfo userInfo) {
		// TODO 自动生成的方法存根
		return this.userInfo.checkUserRight(userInfo);
	}

	@Override
	public List<UserInfo> getAllUser() {
		// TODO 自动生成的方法存根
		return userInfo.selectAllUser();
	}

	@Override
	public int getAllUserNum() {
		// TODO 自动生成的方法存根
		return userInfo.selectAllUerNum();
	}

	@Override
	public List<UserInfo> selectUserByPageNum(Page page) {
		// TODO 自动生成的方法存根
		return userInfo.selectUserByPageNum(page);
	}

	@Override
	public UserInfo getUserByUserId(int id) {
		// TODO 自动生成的方法存根
		return userInfo.selectUserByUserId(id);
	}

	@Override
	public void updateUserById(UserInfo userInfo) {
		// TODO 自动生成的方法存根
		this.userInfo.updateUserByUser(userInfo);
	}

	@Override
	public void deleteUserById(int id) {
		// TODO 自动生成的方法存根
		userInfo.deleteUserById(id);
	}

}

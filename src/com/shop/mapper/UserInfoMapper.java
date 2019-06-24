package com.shop.mapper;

import java.util.List;

import com.shop.entity.Page;
import com.shop.entity.UserInfo;

public interface UserInfoMapper {
	public int insertUser(UserInfo userInfo);
	public int checkExist(String name);
 	public UserInfo checkUserRight(UserInfo userInfo);
 	public List<UserInfo> selectAllUser();
 	public int selectAllUerNum();
 	public List<UserInfo> selectUserByPageNum(Page page);
 	public UserInfo selectUserByUserId(int userId);
 	public void updateUserByUser(UserInfo userInfo);
 	public void deleteUserById(int id) ;
}

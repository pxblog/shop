package com.shop.entity;

import java.io.Serializable;

/**
 * 用户表对应类
 * @author Administrator
 *
 */
public class UserInfo implements Serializable{
	private int id;//用户id
	private String userName;//用户名
	private String pwd;//密码
	private String email;//邮箱
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}

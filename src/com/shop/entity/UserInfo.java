package com.shop.entity;

import java.io.Serializable;

/**
 * �û����Ӧ��
 * @author Administrator
 *
 */
public class UserInfo implements Serializable{
	private int id;//�û�id
	private String userName;//�û���
	private String pwd;//����
	private String email;//����
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

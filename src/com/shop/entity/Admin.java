package com.shop.entity;

public class Admin {
	private int id;
	private	String adminName;
	private String password;
	private String email;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Admin(int id, String adminName, String password, String email) {
		super();
		this.id = id;
		this.adminName = adminName;
		this.password = password;
		this.email = email;
	}
	public Admin() {
		super();
		// TODO 自动生成的构造函数存根
	}
	
	
}

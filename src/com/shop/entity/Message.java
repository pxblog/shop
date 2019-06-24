package com.shop.entity;

public class Message {

	
	private int id;
	private String userName;
	private String email;
	private String messageCont;
	private int status;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMessageCont() {
		return messageCont;
	}
	public void setMessageCont(String messageCont) {
		this.messageCont = messageCont;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}

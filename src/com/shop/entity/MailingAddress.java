package com.shop.entity;

import java.io.Serializable;

public class MailingAddress implements Serializable {
	private int maid;
	private String addressee;   // 收件人
	private String cityAddress;  // 城市
	private String streetAddress; // 地址
	private int defaultAddress;   // 是否是默认地址 0是   1不是
	private String phone;
	private int userid;          // 用户编号
	
	public int getMaid() {
		return maid;
	}
	public void setMaid(int maid) {
		this.maid = maid;
	}
	public String getAddressee() {
		return addressee;
	}
	public void setAddressee(String addressee) {
		this.addressee = addressee;
	}
	public String getCityAddress() {
		return cityAddress;
	}
	public void setCityAddress(String cityAddress) {
		this.cityAddress = cityAddress;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public int getDefaultAddress() {
		return defaultAddress;
	}
	public void setDefaultAddress(int defaultAddress) {
		this.defaultAddress = defaultAddress;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public MailingAddress(String addressee, String cityAddress, String streetAddress,String phone, int userid) {
		super();
		this.addressee = addressee;
		this.cityAddress = cityAddress;
		this.streetAddress = streetAddress;
		this.phone = phone;
		this.userid = userid;
	}
	public MailingAddress() {
		super();
		// TODO 自动生成的构造函数存根
	}
	

}

package com.shop.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单表对应类
 * @author Administrator
 *
 */
public class Orders implements Serializable{
	private String orderId;//订单id
	private String createTime;//订单时间
	private int state;//订单状态 1 未发货  2 已发货    3 已完成  
	private double sumPrice;//订单总价
	private String payType;
	private String postType;
	private String remark;
	private int userid;
	private int maid;
	// 此处增加地址表的字段
	private String addressee;  // 收件人
	private String cityAddress;    // 收件城市
	private String streetAddress;  // 收件地址
	private String phone;     // 电话
	
	public Orders() {
		super();
	}
	
	public int getUserid() {
		return userid;
	}



	public void setUserid(int userid) {
		this.userid = userid;
	}




	public Orders(String orderId, String createTime, int state, double sumPrice,
			String payType, String postType, String remark, int maid) {
		super();
		this.orderId = orderId;
		this.createTime = createTime;
		this.state = state;
		this.sumPrice = sumPrice;
		this.payType = payType;
		this.postType = postType;
		this.remark = remark;
		this.maid = maid;
	}

	
	public Orders(String orderId, String createTime, int state, double sumPrice,
			String payType, String postType, String remark, int maid,String addressee,
			String cityAddress,String streetAddress,String phone,int userid) {
		super();
		this.orderId = orderId;
		this.createTime = createTime;
		this.state = state;
		this.sumPrice = sumPrice;
		this.payType = payType;
		this.postType = postType;
		this.remark = remark;
		this.maid = maid;
		this.addressee = addressee;
		this.cityAddress = cityAddress;
		this.streetAddress = streetAddress;
		this.phone = phone;
		this.userid = userid;
	}
	




	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public double getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(double sumPrice) {
		this.sumPrice = sumPrice;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getPostType() {
		return postType;
	}

	public void setPostType(String postType) {
		this.postType = postType;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

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



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
}

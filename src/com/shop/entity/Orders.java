package com.shop.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * �������Ӧ��
 * @author Administrator
 *
 */
public class Orders implements Serializable{
	private String orderId;//����id
	private String createTime;//����ʱ��
	private int state;//����״̬ 1 δ����  2 �ѷ���    3 �����  
	private double sumPrice;//�����ܼ�
	private String payType;
	private String postType;
	private String remark;
	private int userid;
	private int maid;
	// �˴����ӵ�ַ����ֶ�
	private String addressee;  // �ռ���
	private String cityAddress;    // �ռ�����
	private String streetAddress;  // �ռ���ַ
	private String phone;     // �绰
	
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

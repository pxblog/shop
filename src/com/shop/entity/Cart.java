package com.shop.entity;

import java.io.Serializable;

/**
 * 购物车类
 * @author Administrator
 *
 */
public class Cart implements Serializable{
	
	private int carId;
	private Product product = new Product();//产品
	private int num;//购买数量
	private int uid;//用户的id
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	

	
}

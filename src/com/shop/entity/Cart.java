package com.shop.entity;

import java.io.Serializable;

/**
 * ���ﳵ��
 * @author Administrator
 *
 */
public class Cart implements Serializable{
	
	private int carId;
	private Product product = new Product();//��Ʒ
	private int num;//��������
	private int uid;//�û���id
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

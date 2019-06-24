package com.shop.entity;

import java.io.Serializable;

/**
 * ������ϸ���Ӧ��
 * @author Administrator
 *
 */
public class OrderDetails implements Serializable{
	private int id;//��ϸ���
	private String orderId;//�������
	private int productid;//��Ʒid
	private int num;//��������
	private double price;//��Ʒ�۸�С��
	private String productname;  //����
	private String image;     //ͼƬ
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public OrderDetails() {
		super();
	}
	
	

	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public OrderDetails(int id, String orderId, int productid, int num, Double price,String productname,String image) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.productid = productid;
		this.num = num;
		this.price = price;
		this.productname = productname;
		this.image = image;
	}
	
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
}

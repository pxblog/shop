package com.shop.entity;

import java.io.Serializable;

/**
 * 订单明细表对应类
 * @author Administrator
 *
 */
public class OrderDetails implements Serializable{
	private int id;//明细编号
	private String orderId;//订单编号
	private int productid;//产品id
	private int num;//购买数量
	private double price;//商品价格小计
	private String productname;  //书名
	private String image;     //图片
	
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

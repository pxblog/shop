package com.shop.entity;

import java.io.Serializable;

/**
 * 产品表对应类
 * @author Administrator
 *
 */
public class Product implements Serializable{
	private int id;//产品编号
	private String name;//产品名称
	private double price;//产品价格
	private String img;//产品图片
	private String desc;//产品简介
	private int stock;//产品库存
	private int categoryId;//一级分类
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", img=" + img + ", desc=" + desc
				+ ", stock=" + stock + ", categoryId=" + categoryId + "]";
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	
	public Product() {
		super();
	}
	public Product(int id, String name, double price, String img, String desc,
			int stock) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.img = img;
		this.desc = desc;
		this.stock = stock;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}

	
}

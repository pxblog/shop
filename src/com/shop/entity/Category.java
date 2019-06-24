package com.shop.entity;

import java.util.ArrayList;
import java.util.List;

public class Category {

	private int cid;
	private String cname;
	private int pid;
	private List<Category> childCategories = new ArrayList<Category>();

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public List<Category> getChildCategories() {
		return childCategories;
	}

	public void setChildCategories(List<Category> childCategories) {
		this.childCategories = childCategories;
	}

	@Override
	public String toString() {
		return "["+this.getCid()+","+this.getCname()+"]";
	}
	
	

}

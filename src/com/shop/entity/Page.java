package com.shop.entity;
import java.util.List;

public class Page {
	private int totalPage;
	private int pageNum;
	private int totalRecordsNum;//总记录数
	private int pageSize;//每页的数量
	private int startIndex;//开始索引
	private int prevPageNum;
	private int nextPageNum;
	private int startPage;
	private int endPage;
	//传入页数；总记录数，每一页的大小
	public Page(int pageNum, int totalRecordsNum,int pageSize) {
		this.pageNum = pageNum;
		this.totalRecordsNum = totalRecordsNum;
		this.pageSize=pageSize;
		totalPage = totalRecordsNum%pageSize==0?totalRecordsNum/pageSize:totalRecordsNum/pageSize+1;
		prevPageNum = pageNum-1>0?pageNum-1:1;
		nextPageNum = pageNum+1>totalPage?totalPage:pageNum+1;
		startIndex = (pageNum-1)*pageSize;
		startPage = 1;
		endPage = totalPage;
	}
	
	@Override
	public String toString() {
		return this.totalPage+"/"+this.pageNum;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalRecordsNum() {
		return totalRecordsNum;
	}
	public void setTotalRecordsNum(int totalRecordsNum) {
		this.totalRecordsNum = totalRecordsNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPrevPageNum() {
		return prevPageNum;
	}
	public void setPrevPageNum(int prevPageNum) {
		this.prevPageNum = prevPageNum;
	}
	public int getNextPageNum() {
		return nextPageNum;
	}
	public void setNextPageNum(int nextPageNum) {
		this.nextPageNum = nextPageNum;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	
}

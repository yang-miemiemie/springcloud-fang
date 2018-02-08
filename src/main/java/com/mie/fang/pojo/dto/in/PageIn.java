package com.mie.fang.pojo.dto.in;

public class PageIn {
	private int currentPage;
	private int pageSize;
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getFromIndex() {
		return (currentPage-1)*pageSize;
	}
	public int getToIndex() {
		return  currentPage*pageSize;
	}
	
	public PageIn(int currentPage,int pageSize) {
		this.currentPage=currentPage;
		this.pageSize=pageSize;
	}
}

package com.mie.fang.pojo.dto.out;

public class PageOut {
	private int currentPage;
	private int pageSize;
	private int totalCount;
	private int totalPage;
	
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

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public PageOut(int currentPage,int pageSize,int totalCount) {
		this.currentPage=currentPage;
		this.pageSize=pageSize;
		this.totalCount=totalCount;
	}

	public int getTotalPage() {
		int page=totalCount/pageSize;
		return totalCount%pageSize==0?page:page+1;
	}
}

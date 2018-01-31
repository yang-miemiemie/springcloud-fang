package com.mie.fang.pojo.vo.in;

import java.util.List;

import com.mie.fang.pojo.po.LianjiaPO;

public class ListInVO {
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

	
}

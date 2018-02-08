package com.mie.fang.pojo.vo.out;

import java.util.List;

import com.mie.fang.pojo.dto.out.LianjiaOldDO;
import com.mie.fang.pojo.dto.out.PageOut;

public class LianjiaOldListOutVO extends PageOut{

	private List<LianjiaOldDO> list;
	
	public LianjiaOldListOutVO(int currentPage, int pageSize,int totalCount,List<LianjiaOldDO> list) {
		super(currentPage, pageSize,totalCount);
		this.setList(list);
	}

	public List<LianjiaOldDO> getList() {
		return list;
	}

	public void setList(List<LianjiaOldDO> list) {
		this.list = list;
	}

}

package com.mie.fang.pojo.vo.out;

import java.util.List;

import com.mie.fang.pojo.dto.out.BaseDO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="列表接口返回对象")
public class ListOutVO {
	
	@ApiModelProperty(value="数据列表")
	private List<BaseDO> list;

	public List<BaseDO> getList() {
		return list;
	}

	public void setList(List<BaseDO> list) {
		this.list = list;
	}
	
}

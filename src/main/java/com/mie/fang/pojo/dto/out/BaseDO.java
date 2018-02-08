package com.mie.fang.pojo.dto.out;

import java.io.Serializable;
import java.math.BigDecimal;

import com.mie.fang.pojo.po.LianjiaPO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description="房屋基础信息")
public class BaseDO implements Serializable{
	private static final long serialVersionUID = 1030256839483718348L;
	
	@ApiModelProperty(value="编号")
	private String id;
	@ApiModelProperty(value="名称")
	private String name;
	@ApiModelProperty(value="价格")
	private BigDecimal price;
	@ApiModelProperty(value="地址")
	private String address;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public BaseDO(LianjiaPO po) {
		this.id=po.getId();
		this.name=po.getName();
		this.price=po.getPrice();
		this.address=po.getAddress();
	}
}

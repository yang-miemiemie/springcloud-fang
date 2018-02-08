package com.mie.fang.pojo.dto.out;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mie.fang.pojo.po.LianjiaOldPO;

public class LianjiaOldDO implements Serializable{
	
	private static final long serialVersionUID = -8272261516561298523L;
	private String region;
	private String viliage;
	private String area;
	private int roomcount;
	private int hallcount;
	private BigDecimal price;
	private String publicdate;
	private String link;
	
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getViliage() {
		return viliage;
	}
	public void setViliage(String viliage) {
		this.viliage = viliage;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public int getRoomcount() {
		return roomcount;
	}
	public void setRoomcount(int roomcount) {
		this.roomcount = roomcount;
	}
	public int getHallcount() {
		return hallcount;
	}
	public void setHallcount(int hallcount) {
		this.hallcount = hallcount;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getPublicdate() {
		return publicdate;
	}
	public void setPublicdate(String publicdate) {
		this.publicdate = publicdate;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	public LianjiaOldDO(LianjiaOldPO po) {
		this.region = po.getRegion();
		this.viliage = po.getViliage();
		this.area = po.getArea();
		this.roomcount = po.getRoomcount();
		this.hallcount = po.getHallcount();
		this.price = po.getPrice();
		this.publicdate = po.getPublicdate();
		this.link = po.getLink();
	}
	
}

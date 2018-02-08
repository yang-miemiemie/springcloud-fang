package com.mie.fang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mie.fang.pojo.dto.out.BaseDO;
import com.mie.fang.pojo.dto.out.LianjiaOldDO;
import com.mie.fang.pojo.vo.out.LianjiaOldListOutVO;
import com.mie.fang.pojo.vo.out.ListOutVO;
import com.mie.fang.service.LianjiaOldService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/lianjia_old")
@Api(tags= {"lianjia二手房相关的api"})
public class LianjiaOldController {
	@Autowired
	LianjiaOldService lianjiaOldService;

	@ApiOperation(value="获取区域列表")
	@RequestMapping(value = {"/region"},method=RequestMethod.GET)
	public List<String> region() {
		List<String> list=lianjiaOldService.listAllRegion();
		return list;
	}

	@ApiOperation(value="获取小区列表")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "region", value = "所在区域", required = false, dataType = "string",paramType="query")
	})
	@RequestMapping(value = {"/viliage"},method=RequestMethod.GET)
	public List<String> viliage(@RequestParam(value="region",required=false) String region) {
		List<String> list=lianjiaOldService.listAllViliage(region);
		return list;
	}
	
	@ApiOperation(value="获取房屋列表")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "currentPage", value = "当前页数", required = true, dataType = "int",paramType="path"),
		@ApiImplicitParam(name = "pageSize", value = "每页数量", required = true, dataType = "int",paramType="path"),
		@ApiImplicitParam(name = "region", value = "所在区域", required = false, dataType = "string",paramType="query"),
		@ApiImplicitParam(name = "viliage", value = "所在小区", required = false, dataType = "string",paramType="query")
	})
	@RequestMapping(value = {"/list-{currentPage}-{pageSize}"},method=RequestMethod.GET)
	public LianjiaOldListOutVO list(@PathVariable Integer currentPage,
						  @PathVariable Integer pageSize,
						  @RequestParam(value="region",required=false) String region,
						  @RequestParam(value="viliage",required=false) String viliage) {
		List<LianjiaOldDO> list=lianjiaOldService.page(currentPage, pageSize,region,viliage);
		int totalCount=lianjiaOldService.countAll(region,viliage);
		LianjiaOldListOutVO vo=new LianjiaOldListOutVO(currentPage, pageSize,totalCount, list);
		return vo;
	}
}	

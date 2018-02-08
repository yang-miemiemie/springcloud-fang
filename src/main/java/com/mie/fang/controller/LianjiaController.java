package com.mie.fang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mie.fang.pojo.dto.out.BaseDO;
import com.mie.fang.pojo.vo.out.ListOutVO;
import com.mie.fang.service.LianjiaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/lianjia")
@Api(tags= {"lianjia相关的api"})
public class LianjiaController {
	@Autowired
	LianjiaService lianjiaService;

	@ApiOperation(value="获取房屋列表")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "currentPage", value = "当前页数", required = true, dataType = "int",paramType="path"),
		@ApiImplicitParam(name = "pageSize", value = "每页数量", required = true, dataType = "int",paramType="path")
	})
	@RequestMapping(value = {"/list-{currentPage}-{pageSize}"},method=RequestMethod.GET)
	public ListOutVO list(@PathVariable Integer currentPage,@PathVariable Integer pageSize) {
		ListOutVO vo=new ListOutVO();
		List<BaseDO> list=lianjiaService.page(currentPage, pageSize);
		vo.setList(list);
		return vo;
	}
}	

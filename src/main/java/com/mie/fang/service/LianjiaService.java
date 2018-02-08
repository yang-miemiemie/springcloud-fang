package com.mie.fang.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.mie.fang.dao.LianjiaDao;
import com.mie.fang.pojo.dto.in.PageIn;
import com.mie.fang.pojo.dto.out.BaseDO;
import com.mie.fang.pojo.po.LianjiaPO;

@Service
public class LianjiaService {
	@Autowired
	LianjiaDao lianjiadao;
	
	@Cacheable(value= {"lianjia"})
	public List<BaseDO> page(int currentPage,int pageSize){
		PageIn page=new PageIn(currentPage, pageSize);
		List<LianjiaPO> polist=lianjiadao.page(page);
		List<BaseDO> resultList=new ArrayList<>();
		for (LianjiaPO po : polist) {
			BaseDO dto=new BaseDO(po);
			resultList.add(dto);
		}
		return resultList;
	}
}

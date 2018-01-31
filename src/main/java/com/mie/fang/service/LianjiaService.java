package com.mie.fang.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.mie.fang.dao.LianjiaDao;
import com.mie.fang.pojo.dto.BaseDTO;
import com.mie.fang.pojo.dto.Page;
import com.mie.fang.pojo.po.LianjiaPO;

@Service
public class LianjiaService {
	@Autowired
	LianjiaDao lianjiadao;
	
	@Cacheable(value= {"lianjia"})
	public List<BaseDTO> page(int currentPage,int pageSize){
		Page page=new Page(currentPage, pageSize);
		List<LianjiaPO> polist=lianjiadao.page(page);
		List<BaseDTO> resultList=new ArrayList<>();
		for (LianjiaPO po : polist) {
			BaseDTO dto=new BaseDTO(po);
			resultList.add(dto);
		}
		return resultList;
	}
}

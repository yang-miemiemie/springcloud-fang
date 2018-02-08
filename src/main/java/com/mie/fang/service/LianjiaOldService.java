package com.mie.fang.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.mie.fang.dao.LianjiaOldDao;
import com.mie.fang.pojo.dto.in.PageIn;
import com.mie.fang.pojo.dto.out.BaseDO;
import com.mie.fang.pojo.dto.out.LianjiaOldDO;
import com.mie.fang.pojo.po.LianjiaOldPO;
import com.mie.fang.pojo.po.LianjiaPO;

@Service
public class LianjiaOldService {
	@Autowired
	LianjiaOldDao lianjiaOldDao;

	@Cacheable(value= {"lianjia_old"})
	public List<String> listAllRegion(){
		return lianjiaOldDao.listAllRegion();
	}

	@Cacheable(value= {"lianjia_old"})
	public List<String> listAllViliage(String region) {
		return lianjiaOldDao.listAllViliage(region);
	}

	@Cacheable(value= {"lianjia_old"})
	public List<LianjiaOldDO> page(int currentPage,int pageSize, String region, String viliage){
		PageIn page=new PageIn(currentPage, pageSize);
		List<LianjiaOldPO> polist=lianjiaOldDao.page(page,region,viliage);
		List<LianjiaOldDO> resultList=new ArrayList<>();
		for (LianjiaOldPO po : polist) {
			LianjiaOldDO dto=new LianjiaOldDO(po);
			resultList.add(dto);
		}
		return resultList;
	}

	@Cacheable(value= {"lianjia_old"})
	public int countAll(String region, String viliage) {
		int count= (int)lianjiaOldDao.countAll(region,viliage);
		return count;
	}
}

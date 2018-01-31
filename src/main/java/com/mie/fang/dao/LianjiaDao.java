package com.mie.fang.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mie.fang.pojo.dto.Page;
import com.mie.fang.pojo.po.LianjiaPO;

@Repository
public class LianjiaDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<LianjiaPO> page(Page page){
    	Query query =new Query();
    	List<LianjiaPO> list=mongoTemplate.find(query, LianjiaPO.class).subList(page.getFromIndex(), page.getToIndex());
		return list;
    }
}

package com.mie.fang.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.mie.fang.pojo.dto.in.PageIn;
import com.mie.fang.pojo.po.LianjiaOldPO;
import com.mie.fang.pojo.po.LianjiaPO;
import com.mongodb.BasicDBObject;

@Repository
public class LianjiaOldDao {
	
    @Autowired
    private MongoTemplate mongoTemplate;

	final String collectionName="lianjia_old";
	
    public List<String> listAllRegion(){
    	List<String> list= mongoTemplate.getCollection(collectionName).distinct("region");
		return list;
    }

	public List<String> listAllViliage(String region) {
    	BasicDBObject query =new BasicDBObject();
    	if(StringUtils.hasLength(region)) {
    		query.append("region",region);
    	}
    	List<String> list= mongoTemplate.getCollection(collectionName).distinct("viliage",query);
		return list;
	}
	
    public List<LianjiaOldPO> page(PageIn page, String region, String viliage){
    	Query query =new Query();
    	if(region!=null) {
    		query.addCriteria(Criteria.where("region").is(region));
    	}
    	if(viliage!=null) {
    		query.addCriteria(Criteria.where("viliage").is(viliage));
    	}
    	query.with(new Sort(new Order(Direction.DESC, "publicdate")));
    	query.skip(page.getFromIndex());
    	query.limit(page.getPageSize());
    	List<LianjiaOldPO> list=mongoTemplate.find(query, LianjiaOldPO.class);
		return list;
    }

	public long countAll(String region, String viliage) {
    	Query query =new Query();
    	if(region!=null) {
    		query.addCriteria(Criteria.where("region").is(region));
    	}
    	if(viliage!=null) {
    		query.addCriteria(Criteria.where("viliage").is(viliage));
    	}
    	long count=mongoTemplate.count(query, LianjiaOldPO.class);
		return count;
	}

}

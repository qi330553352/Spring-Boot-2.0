package com.example.qixin.service;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.log4j.Log4j2;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.LimitOperation;
import org.springframework.data.mongodb.core.aggregation.SkipOperation;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.util.StringUtils;

import com.example.qixin.entity.ChangeItem;
import com.example.qixin.feign.ChangeItemApi;
import com.example.qixin.vo.AggregateVO;
import com.mongodb.client.result.UpdateResult;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.sort;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.skip;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.limit;

/**
 * 创  建   时  间： 2018/12/23 13:07
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 */
@Log4j2
@RestController
public class ChangeItemService implements ChangeItemApi {

	@Autowired
    private ReactiveMongoTemplate template;
	
	@Override
	public Mono<ChangeItem> findById(String id) {
		Document queryWhere = new Document();
		Document fieldName = new Document();
		fieldName.put("id", true);
		BasicQuery query = new BasicQuery(queryWhere, fieldName);
		query.addCriteria(Criteria.where("idx").gte(1));
		
		//2.----or 多条件查询-----------------
		Criteria criteria = new Criteria();
		List<Criteria> criterias = new ArrayList<>();
		criterias.add(where("idx").lte(1).and("idx").gt(10));
		Criteria[] ca = new Criteria[criterias.size()];
		criterias.toArray(ca);
		criteria.orOperator(ca);
		query.addCriteria(criteria);
		return template.findOne(Query.query(where("id").is(id)),ChangeItem.class);
	}

	@Override
	public Flux<ChangeItem> findLike(Long currPage, Integer pageSize,String changeName) {
		Query query = new Query();
		if(!StringUtils.isEmpty(changeName)) query.addCriteria(where("changeName").regex(".*" + changeName + ".*", "i"));
		if(currPage!=null && pageSize!=null) query.skip((currPage - 1) * pageSize).limit(pageSize);
		query.with(new Sort(Sort.Direction.DESC, "createTime"));//Sort.Order.desc("createTime")
		return template.find(query, ChangeItem.class);
	}

	@Override
	public Mono<UpdateResult> updateById(String id) {
		Query query = Query.query(where("id").is(id));
		Update update = Update.update("idx", 1);
		return template.updateFirst(query,update, ChangeItem.class);
	}

	@Override
	public Flux<AggregateVO> aggregate(long currPage,Integer pageSize) {
		AggregationOperation matchs = match(Criteria.where("changeName").exists(true));
		AggregationOperation group = group("changeName").count().as("total");
		AggregationOperation sorts = sort(Sort.Direction.DESC,"createTime");
		SkipOperation skips = skip((currPage-1) * pageSize);
		LimitOperation limits = limit(pageSize);
		TypedAggregation<ChangeItem> agg = Aggregation.newAggregation(ChangeItem.class,sorts,matchs,group,skips,limits);
		return template.aggregate(agg, AggregateVO.class);
	}
	
	

}

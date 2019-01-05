package com.example.qixin.service;

import com.example.qixin.entity.PatentInfo;
import com.example.qixin.feign.PatentInfoApi;
import com.example.qixin.repository.PatentInfoRepository;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang.StringUtils;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Timestamp;

/**
 * 创  建   时  间： 2018/12/23 13:07
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 */
@Log4j2
@RestController
public class PatentInfoService implements PatentInfoApi {

    @Autowired
    private PatentInfoRepository repository;

	@Override
	public Mono<PatentInfo> findById(String id) {

		return repository.findById(id);
	}


    @Override
    public Mono<PatentInfo> save(PatentInfo bean) {

       return repository.save(bean);
    }

    @Override
	public Flux<PatentInfo> saveAll(Iterable<PatentInfo> beans) {
		
		return repository.saveAll(beans);
	}
    
	@Override
	public Mono<PatentInfo> findByIds(Publisher<String> ids) {
		
		return repository.findById(ids);
	}


	@Override
	public Mono<Boolean> existsById(String id) {
		
		return repository.existsById(id);
	}

	@Override
	public Mono<Boolean> existsByIds(Publisher<String> ids) {

		return repository.existsById(ids);
	}

	@Override
	public Flux<PatentInfo> findList(PatentInfo bean) {
		ExampleMatcher matcher = ExampleMatcher.matching() //构建对象
				.withMatcher("sqh", ExampleMatcher.GenericPropertyMatchers.contains()) //sqh 采用开始匹配的方式查询
				.withIgnorePaths("id"); //忽略属性：是否关注。因为是基本类型，需要忽略掉

		Example<PatentInfo> example = Example.of(bean,matcher); //创建实例
		return repository.findAll(example);
	}

	@Override
	public Page<PatentInfo> findListByPage(PatentInfo bean, @PageableDefault(sort = {"idx"}, page = 0, size = 10) Pageable page) {
		// Pageable pageable = PageRequest.of(pageNumber,pageSize,Sort.Direction.DESC,"id");
		//Specification查询构造器
		Specification<PatentInfo> specification = new Specification<PatentInfo>() {

			private static final long serialVersionUID = 1L;
			@Override
			public Predicate toPredicate(Root<PatentInfo> root, CriteriaQuery<?> query, CriteriaBuilder criteria) {
				Predicate condition1 = null;
				if(StringUtils.isNotBlank(bean.getSqh())) {
					condition1 = criteria.like(root.get("sqh"),"%"+bean.getSqh()+"%");
				}else {
					condition1 = criteria.like(root.get("sqh"),"%%");
				}
				Predicate condition2 = null;
				if(bean.getCreateTime()!=null) {
					condition2 = criteria.greaterThan(root.get("createTime"), bean.getCreateTime());
				}else {
					condition2 = criteria.greaterThan(root.get("createTime"), new Timestamp(1514736000000L));
				}
				//Predicate conditionX=criteriaBuilder.and(condition1,condition2);
				//query.where(conditionX);
				query.where(condition1,condition2);
				//query.where(getPredicates(condition1,condition2)); //这里可以设置任意条查询条件
				return null;  //这种方式使用JPA的API设置了查询条件，所以不需要再返回查询条件Predicate给Spring Data Jpa，故最后return null
			}
		};
		return null;
	}

}

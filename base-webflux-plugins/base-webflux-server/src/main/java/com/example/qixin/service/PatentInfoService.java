package com.example.qixin.service;

import lombok.extern.log4j.Log4j2;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.example.qixin.entity.PatentInfo;
import com.example.qixin.feign.PatentInfoApi;
import com.example.qixin.repository.PatentInfoRepository;

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
	public Mono<PatentInfo> findById(String id) {
		
		return repository.findById(id);
	}

	@Override
	public Mono<Boolean> existsById(String id) {
		
		return repository.existsById(id);
	}

	@Override
	public Mono<Boolean> existsByIds(Publisher<String> ids) {

		return repository.existsById(ids);
	}

}

package com.example.qixin.feign;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

import javax.annotation.Resource;

import org.reactivestreams.Publisher;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.example.qixin.entity.PatentInfo;

/**
 * 创  建   时  间： 2018/12/23 13:02
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 */
@Api(value = "示例接口C")
@Resource(name = "示例接口D")
@RequestMapping("/PatentInfoApi")
public interface PatentInfoApi {

    @PostMapping("/save")
    @ApiOperation(value="创建对象", notes="根据bean创建对象")
    @ApiImplicitParam(name = "bean", value = "对象", required = true, dataType = "PatentInfo")
    Mono<PatentInfo> save(@RequestBody PatentInfo bean);
    
    //TODO 该类型不知道怎么使用 Publisher<S> paramPublisher
    @PostMapping("/saveAll")
    Flux<PatentInfo> saveAll(@RequestBody Iterable<PatentInfo> beans);
    
    @GetMapping("/findById/{id}")
    Mono<PatentInfo> findById(@PathVariable String id);

    @GetMapping(value="/findByIds",consumes = MediaType.APPLICATION_JSON_VALUE)
    Mono<PatentInfo> findByIds(@RequestBody Publisher<String> ids);
    
    @GetMapping("/existsById/{id}")
    Mono<Boolean> existsById(@PathVariable String id);
    
    @GetMapping("/existsByIds")
    Mono<Boolean> existsByIds(@RequestBody Publisher<String> ids);
    
    
}

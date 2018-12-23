package com.example.qixin.feign;

import com.example.qixin.entity.PatentInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

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



}

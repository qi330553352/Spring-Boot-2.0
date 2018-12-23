package com.example.qixin.feign;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 创  建   时  间： 2018/12/23 10:56
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 */
@RestController
@Api(value = "示例接口C")
@Resource(name = "示例接口D")
@RequestMapping("/IntegrationFileApi")
public interface IntegrationFileApi {

}

package com.example.qixin.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 创  建   时  间： 2019/1/5 13:23
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){

        return "Hello World";
    }

}

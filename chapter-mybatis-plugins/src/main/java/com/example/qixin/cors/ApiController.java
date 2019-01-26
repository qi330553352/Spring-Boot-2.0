package com.example.qixin.cors;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/** 解决跨域问题：局部配置
 * 创  建   时  间： 2019/1/26 21:53
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 */
@RestController
@RequestMapping(value = "/api", method = RequestMethod.POST)
public class ApiController {

    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "/get")
    public HashMap<String, Object> get(@RequestParam String name) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("title", "hello world");
        map.put("name", name);
        return map;
    }
}

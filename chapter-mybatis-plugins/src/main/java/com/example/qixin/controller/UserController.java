package com.example.qixin.controller;

import com.example.qixin.entity.UserInfo;
import com.example.qixin.service.UserInfoService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 创  建   时  间： 2019/1/24 20:40
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 */
@Log4j2
@RestController
@RequestMapping(value="/userController")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;
    static Map<Long, UserInfo> users = Collections.synchronizedMap(new HashMap<Long, UserInfo>());

    @ApiOperation(value = "获取用户列表", notes = "用户列表", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping("/users/{page}/{pagesize}")
    public List<UserInfo> users(@ApiParam(name = "page", value = "当前页号", defaultValue = "1", required = true) @PathVariable("page") Integer page,
                                 @ApiParam(name = "pagesize", value = "分页大小", defaultValue = "10", required = true) @PathVariable("pagesize") Integer pagesize) {
        log.info("获取用户列表 page:{} pagesize:{}",page,pagesize);
        return userInfoService.findUsers(page,pagesize);
    }

    @PostMapping("/user/save")
    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "UserInfo")
    public Map<String,Object> save(@RequestBody UserInfo user) {
        log.info("创建用户 参数:{}",user);
        Map<String,Object> map = new HashMap<>();
        int resultTag = userInfoService.save(user);
        map.put("success",resultTag!=0);
        map.put("msg","请求成功");
        return map;
    }

    @RequestMapping(value="/user/{id}", method= RequestMethod.GET)
    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    public UserInfo user(@PathVariable Long id) {
        log.info("参数 id:{}",id);
        return  userInfoService.findById(id);
    }

    @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @RequestBody UserInfo user) {
        log.info("");
        UserInfo u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id, u);
        return "success";
    }

    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        log.info("");
        users.remove(id);
        return "success";
    }
}

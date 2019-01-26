package com.example.qixin.service;

import com.example.qixin.entity.UserInfo;
import com.example.qixin.mapper.UserInfoMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 创  建   时  间： 2019/1/22 0:50
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 */
@Log4j2
@Service
public class UserInfoService{

    @Autowired
    private UserInfoMapper mapper;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Transactional
    public int save(UserInfo user) {
        int result = mapper.save(user);
        redisTemplate.opsForValue().set("user:"+user.getId(),user);
        return result;
    }

    public List<UserInfo> findUsers(Integer page, Integer pageSize) {
        Integer start = (page - 1) * pageSize;
        return mapper.findUsers(start,pageSize);
    }

    public UserInfo findById(Long id) {
        Object obj = redisTemplate.opsForValue().get("user:"+id);
        log.info("获得redis中的对象:"+obj);
        if(obj instanceof UserInfo){
            return (UserInfo)obj;
        }
        log.info("获得redis中的对象失败");
        return mapper.findById(id);
    }


}

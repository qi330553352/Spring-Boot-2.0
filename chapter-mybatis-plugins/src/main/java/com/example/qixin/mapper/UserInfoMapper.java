package com.example.qixin.mapper;

import com.example.qixin.entity.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheConfig;

import java.util.List;

/**
 * 创  建   时  间： 2019/1/22 0:44
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 */
@CacheConfig(cacheNames = "UserInfo")
public interface UserInfoMapper {

    UserInfo findById(Long id);

    int deleteById(Long id);

    int save(UserInfo bean);

    List<UserInfo> findAll();

    List<UserInfo> findUsers(@Param("start") Integer start, @Param("pageSize")Integer pageSize);
}

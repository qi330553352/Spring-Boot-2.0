package com.example.qixin.service;

import com.example.qixin.entity.UserInfo;
import com.example.qixin.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 创  建   时  间： 2019/1/22 0:50
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper mapper;

    @Override
    public int save(UserInfo user) {

        return mapper.save(user);
    }
}

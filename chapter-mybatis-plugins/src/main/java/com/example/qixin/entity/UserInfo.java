package com.example.qixin.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 创  建   时  间： 2019/1/22 0:42
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 */
@Data
public class UserInfo implements Serializable {

    private Long id;
    private String name;
    private int age;
    private Date createTime;

    public UserInfo() {
    }

    public UserInfo(Long id, String name, int age, Date createTime) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.createTime = createTime;
    }
}

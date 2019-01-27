package com.example.qixin.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 创  建   时  间： 2019/1/27 13:09
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 */
@Data
public class Book implements Serializable {

    /**编号*/
    private Long id;
    /**书名*/
    private String name;
    /**作者*/
    private String writer;
    /**简介*/
    private String introduction;
}

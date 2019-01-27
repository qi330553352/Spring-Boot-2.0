package com.example.qixin.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * 创  建   时  间： 2019/1/27 12:39
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 */
@Data
@Document(collection = "City")
public class City implements Serializable{

    /** 城市编号 */
    @Id
    private Long id;
    /** 省份编号 */
    private Long provinceId;
    /** 城市名称 */
    private String cityName;
    /** 描述 */
    private String description;
}

package com.example.qixin.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * 创  建   时  间： 2018/12/23 12:47
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 */
@Data
@Document(collection = "PatentInfo")
public class PatentInfo implements Serializable {

    @Id
    private String id;
    private String fileType;
    /** 公开（公告）号 */
    private String gkh;
    /** 公开（公告）日 */
    private String gkr;
    /** 申请号 */
    private String sqh;
    /** 申请日  */
    private String sqr;
    /** 名称 */
    private String mc;
    /** 主分类号 */
    private String zflh;
    /** 分类号 */
    private String flh;
    /** 申请（专利权）人 */
    private String zlqr;
    /** 发明（设计）人 */
    private String fmr;
    /** 摘要 */
    private String zy;
    /** 主权项 */
    private String zqx;
    /** 优先权 */
    private String yxq;
    /** 国省代码 */
    private String gsdm;
    /** 地址 */
    private String dz;
    /** 专利代理机构 */
    private String zldljg;
    /** 代理人 */
    private String dlr;
    /** 发布路径 */
    private String fblj;
    /** 页数 */
    private Integer ys;
    /** 申请国代码 */
    private String sqgdm;
    /** 专利类型 */
    private String zllx;
    /** 申请来源 */
    private String sqly;
    /** 权利要求书页数 */
    private String qlyqsys;
    /** 说明书页数 */
    private String smsys;
    /** TRSKeyword */
    private String trskeyword;
    /** ABS */
    private String abs;
    private Date createTime;
    /** 序号 */
    private Integer idx;
}

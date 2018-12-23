package com.example.qixin.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 创  建   时  间： 2018/12/23 12:47
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 */
@Data
@Document(collection = "ChangeItem")
public class ChangeItem implements Serializable {

	private static final long serialVersionUID = -3354189348765823963L;
	
	@Id
	private String id;
	private String flztId;
	private String changeName;
	private String before;
	private String after;
	private Integer idx;
	private Date createTime;
}

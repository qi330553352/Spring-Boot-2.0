package com.example.qixin.vo;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class AggregateVO {

	@Id
	private String id;
	private long total;
	private long sum;
}

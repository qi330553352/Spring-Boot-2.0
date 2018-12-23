package com.example.qixin.feign;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.qixin.entity.ChangeItem;
import com.example.qixin.vo.AggregateVO;
import com.mongodb.client.result.UpdateResult;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 创  建   时  间： 2018/12/23 13:02
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 */
@RequestMapping("/ChangeItemApi")
public interface ChangeItemApi {
	
	/**
	 * 根据ID查询对象
	 * @param id
	 * @return
	 */
	@GetMapping("/findById/{id}")
	Mono<ChangeItem> findById(@PathVariable String id);
	
	/**
	 * 根据名称模糊查询
	 * @param page
	 * @param pageSize
	 * @param changeName
	 * @return
	 */
	@GetMapping("/findLike")
	Flux<ChangeItem> findLike(//
			@RequestParam(value = "currPage", required = false) Long currPage,//
			@RequestParam(value = "pageSize", required = false) Integer pageSize,//
			@RequestParam(value = "changeName", required = false) String changeName);
	
	/**
	 * 根据ID每次做+1操作
	 * @param id
	 * @return
	 */
	@PostMapping("/updateById/{id}")
	Mono<UpdateResult> updateById(@PathVariable String id);
	
	/**
	 * 数据统计
	 * @return
	 */
	@GetMapping("/aggregate/{currPage}/{pageSize}")
	Flux<AggregateVO> aggregate(@PathVariable long currPage,@PathVariable Integer pageSize);
}

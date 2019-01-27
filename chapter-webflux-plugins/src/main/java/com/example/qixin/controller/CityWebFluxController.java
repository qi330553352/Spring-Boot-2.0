package com.example.qixin.controller;

import com.example.qixin.domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;

/**
 * 创  建   时  间： 2019/1/27 12:47
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 */
@RestController
@RequestMapping(value = "/city")
public class CityWebFluxController {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping(value = "/{id}")
    public Mono<City> findCityById(@PathVariable("id") Long id) {
        String key = "city_" + id;
        ValueOperations<String, City> operations = redisTemplate.opsForValue();
        boolean hasKey = redisTemplate.hasKey(key);
        City city = operations.get(key);

        if (!hasKey) {
            return Mono.create(monoSink -> monoSink.success(null));
        }
        return Mono.create(monoSink -> monoSink.success(city));
    }

    @PostMapping()
    public Mono<City> saveCity(@RequestBody City city) {
        String key = "city_" + city.getId();
        ValueOperations<String, City> operations = redisTemplate.opsForValue();
        operations.set(key, city, 60, TimeUnit.SECONDS);

        return Mono.create(monoSink -> monoSink.success(city));
    }

    @DeleteMapping(value = "/{id}")
    public Mono<Long> deleteCity(@PathVariable("id") Long id) {
        String key = "city_" + id;
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            redisTemplate.delete(key);
        }
        return Mono.create(monoSink -> monoSink.success(id));
    }

//    @Autowired
//    private ReactiveRedisTemplate reactiveRedisTemplate;
//
//    @GetMapping(value = "/{id}")
//    public Mono<City> findCityById(@PathVariable("id") Long id) {
//        String key = "city_" + id;
//        ReactiveValueOperations<String, City> operations = reactiveRedisTemplate.opsForValue();
//        Mono<City> city = operations.get(key);
//        return city;
//    }
//
//    @PostMapping
//    public Mono<City> saveCity(@RequestBody City city) {
//        String key = "city_" + city.getId();
//        ReactiveValueOperations<String, City> operations = reactiveRedisTemplate.opsForValue();
//        return operations.getAndSet(key, city);
//    }
//
//    @DeleteMapping(value = "/{id}")
//    public Mono<Long> deleteCity(@PathVariable("id") Long id) {
//        String key = "city_" + id;
//        return reactiveRedisTemplate.delete(key);
//    }
}

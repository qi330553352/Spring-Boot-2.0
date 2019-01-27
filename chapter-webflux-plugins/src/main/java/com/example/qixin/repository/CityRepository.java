package com.example.qixin.repository;

import com.example.qixin.domain.City;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 创  建   时  间： 2019/1/27 12:55
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 */
@Repository
public interface CityRepository extends ReactiveMongoRepository<City,Long> {

//    Flux<City> findByLastname(String lastname);
//
//    @Query("{ 'firstname': ?0, 'lastname': ?1}")
//    Mono<City> findByFirstnameAndLastname(String firstname, String lastname);
//
//    // Accept parameter inside a reactive type for deferred execution
//    Flux<City> findByLastname(Mono<String> lastname);
//
//    Mono<City> findByFirstnameAndLastname(Mono<String> firstname, String lastname);
//
//    @Tailable // Use a tailable cursor
//    Flux<City> findWithTailableCursorBy();
}

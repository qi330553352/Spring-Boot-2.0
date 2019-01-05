package com.example.qixin.data;

import com.example.qixin.BaseWebfluxServerApplication;
import com.example.qixin.entity.PatentInfo;
import com.example.qixin.entity.PatentTempInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * 创  建   时  间： 2018/12/29 23:16
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BaseWebfluxServerApplication.class)
public class PatentInfoTests {

    @Autowired
    private ReactiveMongoTemplate template;

    @Test
    public void test(){
        //total:853371 0
        Query query = new Query();
        query.addCriteria(where("sqh").exists(true));
        query.with(new Sort(Sort.Direction.ASC, "idx"));
        query.skip(0);
        query.limit(100000);
        Flux<PatentTempInfo> list = template.find(query,PatentTempInfo.class);
        System.out.println("--------------------------");
        System.out.println("");
        System.out.println("list.size:"+list.count().block());
        List<PatentInfo> beans = list.toStream().map(entity->{
            PatentInfo bean = new PatentInfo();
            BeanUtils.copyProperties(entity,bean);
            bean.setTableName("Patent2000");
            return bean;
        }).collect(Collectors.toList());
        Flux<PatentInfo> result = template.insertAll(beans);
        System.out.println("");
        System.out.println("");
        System.out.println("total:"+result.count().block());
    }
}

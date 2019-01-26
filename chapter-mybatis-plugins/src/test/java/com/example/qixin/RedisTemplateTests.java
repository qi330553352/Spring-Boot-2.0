package com.example.qixin;

import com.example.qixin.entity.UserInfo;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 创  建   时  间： 2019/1/26 14:41
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 */
@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ChapterMybatisPluginsApplication.class)
public class RedisTemplateTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test //操作字符串
    public void stringTest(){
//        redisTemplate.opsForValue().set("string","this is string ...");
//        redisTemplate.opsForValue().append("string","append content"); //在key键对应值的右面追加值value
//        redisTemplate.opsForValue().set("integer",1000);
//        redisTemplate.opsForValue().set("boolean",true);
//        byte[] types = "abc".getBytes();
//        redisTemplate.opsForValue().set("bype",types);
//        UserInfo userInfo = new UserInfo();
//        userInfo.setCreateTime(new Date());
//        userInfo.setName("test");
//        userInfo.setAge(20);
//        userInfo.setId(1000L);
//        redisTemplate.opsForValue().set("userInfo",userInfo);

//        log.info("opsForValue()");
//        log.info(redisTemplate.opsForValue().get("string"));
//        log.info(redisTemplate.opsForValue().get("integer"));
//        log.info(redisTemplate.opsForValue().get("boolean"));
//        log.info(redisTemplate.opsForValue().get("bype"));
//        log.info(redisTemplate.opsForValue().get("userInfo"));
//
//        redisTemplate.opsForValue().getOperations().delete("string");  //删除
    }

    @Test
    public void listTest(){
        log.info("listTest()");
        List<UserInfo> list = new ArrayList<>();
        list.add(new UserInfo(1L,"1111qixin1",31,new Date()));
        list.add(new UserInfo(2L,"qixin2",32,new Date()));
        list.add(new UserInfo(3L,"qixin3",33,new Date()));
        list.add(new UserInfo(4L,"qixin4",34,new Date()));
        list.add(new UserInfo(5L,"qixin5",35,new Date()));
//        redisTemplate.opsForList().leftPush("list", list);//从左向右存压栈

//        ArrayList<UserInfo> operations = (ArrayList<UserInfo>) redisTemplate.opsForList().leftPop("list");//从左出栈
//        log.info(operations.size());
//        log.info(operations);

//        Object obj = redisTemplate.opsForList().size("list");//队/栈长
//        log.info(obj);

        Object obj = redisTemplate.opsForList().range("list", 1, 3);//范围检索,返回List
        log.info(obj);
//        redisTemplate.opsForList().remove("list", i, list);//移除key中值为value的i个,返回删除的个数；如果没有这个元素则返回0
//        redisTemplate.opsForList().index("list", index);//检索
//        redisTemplate.opsForList().set("list", index, list);//赋值
//        redisTemplate.opsForList().trim("list", start, end);//裁剪,void,删除除了[start,end]以外的所有元素
//        redisTemplate.opsForList().rightPopAndLeftPush(String sourceKey, String destinationKey);//将源key的队列的右边的一个值删除，然后塞入目标key的队列的左边，返回这个值
    }

}

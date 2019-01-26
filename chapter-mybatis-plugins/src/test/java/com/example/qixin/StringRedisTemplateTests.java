package com.example.qixin;

import lombok.extern.log4j.Log4j2;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 创  建   时  间： 2019/1/26 15:52
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 */
@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ChapterMybatisPluginsApplication.class)
public class StringRedisTemplateTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

}

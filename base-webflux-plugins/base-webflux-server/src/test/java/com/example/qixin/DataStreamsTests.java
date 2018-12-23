package com.example.qixin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 创  建   时  间： 2018/12/23 17:20
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BaseWebfluxServerApplication.class)
public class DataStreamsTests {

    @Test
    public void test(){
        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
        Stream.of("a1", "a2", "a3");
        IntStream.range(1, 4);

    }
}

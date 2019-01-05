package com.example.qixin;

import com.example.qixin.scheduled.AsyncTesks;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;

/**
 * 创  建   时  间： 2018/12/23 16:08
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BaseWebfluxServerApplication.class)
public class StreamsTests {

    @Autowired
    private AsyncTesks task;


    public void setUp(){

    }


    @Test
    public void test() throws InterruptedException {
        long start = System.currentTimeMillis();

        Future<String> task1 = task.doTaskOne();
        Future<String> task2 = task.doTaskTwo();
        Future<String> task3 = task.doTaskThree();

        while(true) {
            if(task1.isDone() && task2.isDone() && task3.isDone()) {
                // 三个任务都调用完成，退出循环等待
                break;
            }
            Thread.sleep(1000);
        }

        long end = System.currentTimeMillis();

        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
    }

    @Test
    public void test1(){
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");

        //filter
        stringCollection//
                .stream()//
                .filter((a)->a.startsWith("a"))//
                .forEach(System.out::println);

        //sorted
        stringCollection//
                .stream()//
                .sorted()//
                .forEach(System.out::println);

        //map
        stringCollection//
                .stream()//
                .map(String::toUpperCase)//
                .sorted((o1, o2)->o2.compareTo(o1))//
                .forEach(System.out::println);

        //anyMatch
        boolean anyStartsWithA =stringCollection//
                .stream()//
                .anyMatch(a->a.startsWith("a"));
        System.out.println("anyStartsWithA:"+anyStartsWithA);

        //allMatch
        boolean allStartsWithA  =stringCollection//
                .stream()//
                .allMatch(a->a.startsWith("a"));
        System.out.println("allStartsWithA:"+allStartsWithA);

        //noneMatch
        boolean noneStartsWithZ  =stringCollection//
                .stream()//
                .noneMatch(a->a.startsWith("a"));
        System.out.println("noneStartsWithZ:"+noneStartsWithZ);

        //count
        long startsWithB = stringCollection//
                .stream()//
                .filter(a->a.startsWith("a"))//
                .count();
        System.out.println("startsWithB:"+startsWithB);

        //该操作是一个终结操作，它能够通过某一个方法，对元素进行削减操作。
        Optional<String> reduced = stringCollection//
                .stream()//
                .sorted()//
                .reduce((o1, o2)->o1+"#"+o2);
        reduced.ifPresent(System.out::println);

    }


}

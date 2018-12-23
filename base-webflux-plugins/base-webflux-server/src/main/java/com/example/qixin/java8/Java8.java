package com.example.qixin.java8;

/**
 * 创  建   时  间： 2018/12/23 14:37
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 */
public interface Java8 {

    double calculate(int a);

    /**
     * 为接口添加非抽象方法的实现
     */
    default double sqrt(int a){

        return Math.sqrt(a);
    }

}

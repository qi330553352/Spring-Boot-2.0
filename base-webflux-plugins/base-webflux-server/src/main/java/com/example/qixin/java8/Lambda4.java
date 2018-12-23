package com.example.qixin.java8;

/** 访问成员变量和静态变量
 * 创  建   时  间： 2018/12/23 16:00
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 */
public class Lambda4 {

    static int outerStaticNum;
    int outerNum;

    void testScopes() {
        Converter<Integer,String> converter = (from)->{
            outerNum = 23;
            return String.valueOf(from);
        };

        Converter<Integer,String> converterd = (from) ->{
            outerStaticNum = 11;
            return String.valueOf(from);
        };
    }
}

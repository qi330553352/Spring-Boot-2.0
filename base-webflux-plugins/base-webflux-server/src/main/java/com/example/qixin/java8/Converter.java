package com.example.qixin.java8;

/** 函数式接口
 * 创  建   时  间： 2018/12/23 15:24
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 */
public interface Converter<F, T> {

    T convert(F from);
}

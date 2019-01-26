package com.example.qixin.listener;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/** 自定义监听器
 * 创  建   时  间： 2019/1/26 21:11
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 */
@Log4j2
//@WebListener  方法三
public class CustomListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("----------contextInitialized-----------");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("----------contextDestroyed-----------");
    }
}

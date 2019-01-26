package com.example.qixin.exceptionHandler;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 统一异常处理：方法一
 * 创  建   时  间： 2019/1/26 18:27
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 */
//@Log4j2
//@Controller
//public class BaseErrorController implements ErrorController {
//
//    @Override
//    public String getErrorPath() {
//        log.info("出错啦！进入自定义错误控制器");
//
//        return "error/error";  //自定义错误页面
//    }
//
//    @RequestMapping("/error")
//    public String error() {
//        log.info("------------/error----------");
//        return getErrorPath();
//    }
//}

package com.example.qixin.exceptionHandler;

import com.alibaba.fastjson.JSON;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/** 统一异常处理：方法二
 * 创  建   时  间： 2019/1/26 18:47
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 */
@Log4j2
@ControllerAdvice
public class ErrorExceptionHandler {


    @ExceptionHandler({ RuntimeException.class })
    @ResponseStatus(HttpStatus.OK)
    public void processException(HttpServletResponse response,RuntimeException exc) {
        log.info("自定义异常处理-RuntimeException");
        Map<String,Object> map = new HashMap<>();
        map.put("success",false);
        map.put("msg",exc.toString());
        String jsonMsg = JSON.toJSONString(map);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.append(jsonMsg);
            log.debug("返回是\n");
            log.debug(jsonMsg);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }

    }

//    @ExceptionHandler({ RuntimeException.class })
//    @ResponseStatus(HttpStatus.OK)
//    public ModelAndView processException(RuntimeException exception) {
//        log.info("自定义异常处理-RuntimeException");
//        ModelAndView m = new ModelAndView();
//        m.addObject("roncooException", exception.toString());
//        m.setViewName("error/500");
//        return m;
//    }

    @ExceptionHandler({ Exception.class })
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView processException(Exception exception) {
        log.info("自定义异常处理-Exception");
        ModelAndView m = new ModelAndView();
        m.addObject("roncooException", exception.getMessage());
        m.setViewName("error/500");
        return m;
    }
}

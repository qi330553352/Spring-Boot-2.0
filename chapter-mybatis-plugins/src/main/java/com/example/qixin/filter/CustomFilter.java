package com.example.qixin.filter;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import java.io.IOException;

/**
 * 创  建   时  间： 2019/1/26 21:08
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 */
@Log4j2
//@WebFilter(filterName = "customFilter", urlPatterns = "/*") 方法三
public class CustomFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("-----------init---------------");
    }

    @Override
    public void destroy() {
        log.info("-----------destroy---------------");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("-----------doFilter---------------");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}

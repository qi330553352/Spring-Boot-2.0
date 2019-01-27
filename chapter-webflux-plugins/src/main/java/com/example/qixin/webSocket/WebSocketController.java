package com.example.qixin.webSocket;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/** http://localhost:8080/webSocket
 * 创  建   时  间： 2019/1/27 20:34
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 */
@Controller
@RequestMapping(value = "/webSocket")
public class WebSocketController {

    @RequestMapping(method = RequestMethod.GET)
    public String getBookList(ModelMap map) {

        return "websocket-client";
    }
}

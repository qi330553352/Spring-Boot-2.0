package com.example.qixin.webSocket;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Mono;

import java.util.List;

/** EchoHandler 处理类
 * 创  建   时  间： 2019/1/27 20:20
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 */
@Log4j2
@Component
public class EchoHandler implements WebSocketHandler {
    @Override
    public List<String> getSubProtocols() {
        log.info("-----------getSubProtocols-------------");
        return null;
    }

    @Override
    public Mono<Void> handle(WebSocketSession session) {
        log.info("-----------handle-------------");
        return session.send(
                session.receive()
                        .map(msg -> session.textMessage(
                                "服务端返回：小明， -> " + msg.getPayloadAsText())));
    }
}

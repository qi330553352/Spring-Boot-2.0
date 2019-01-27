package com.example.qixin.webSocket;

import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient;
import org.springframework.web.reactive.socket.client.WebSocketClient;
import reactor.core.publisher.Flux;

import java.net.URI;
import java.time.Duration;

/** WSClient Java 客户端实现
 * 创  建   时  间： 2019/1/27 20:27
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 */
public class WSClient {

    public static void main(final String[] args) {
        final WebSocketClient client = new ReactorNettyWebSocketClient();
        client.execute(URI.create("ws://127.0.0.1:8080/echo"), session ->
                session.send(Flux.just(session.textMessage("你好")))
                        .thenMany(session.receive().take(1).map(WebSocketMessage::getPayloadAsText))
                        .doOnNext(System.out::println)
                        .then())
                .block(Duration.ofMillis(5000));
    }
}

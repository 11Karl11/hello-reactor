package com.karl.reactor.vertx;

import io.vertx.core.Vertx;

/**
 * @author karl xie
 */
public class EventBusDemo {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        demoEvenBus(vertx);
        vertx.close();

    }

    private static void demoEvenBus(Vertx vertx) {

        String address ="test-address";

        //事件订阅者（处理事件）
        //消息通过地址区分，事件通过类型区分
        vertx.eventBus().consumer(address, message -> {
            //处理消息
            Object payload = message.body();
            System.out.printf("Address: test-address-> message:%s\n", payload);
        }).completionHandler(handler->{
            System.out.println("消息消费结束");
        });

        //事件发布者（发布事件）
        vertx.eventBus().publish(address,"Hello World");
        vertx.eventBus().publish(address,123456);
    }

}
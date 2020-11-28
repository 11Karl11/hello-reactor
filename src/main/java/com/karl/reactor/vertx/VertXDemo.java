package com.karl.reactor.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;

/**
 * @author karl xie
 */
public class VertXDemo {

    public static void main(String[] args) {

        //Reactor
        //RxJava 1 or 2
        //Vertx Builder 模式
        Vertx vertx = Vertx.vertx();
        demoVerticle(vertx);
        vertx.close();

    }


    /**
    * @Description:  演示部署 Verticle
    * @Param: [vertx]
    * @return: void
    * @Date: 2020/11/28
    */
    private static void demoVerticle(Vertx vertx){

        vertx.deployVerticle(new AbstractVerticle() {
            @Override
            public void start(Future<Void> startFuture) throws Exception {
                System.out.println("start");
                startFuture.complete();
            }

            @Override
            public void stop() throws Exception {
                System.out.println("stop");
            }
        });
    }

    private static void demoStPeriodic(Vertx vertx){
        //实现定时器
        //500毫秒 执行打印
        vertx.setPeriodic(500,System.out::println);
        //vertx.setPeriodic(500,System.out::println);
    }
}
package com.karl.reactor.vertx;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;

/**
 * @author karl xie
 */
public class VertxWebDemo {

    public static void main(String[] args) {

        Vertx vertx = Vertx.vertx();

        //路由对象

        Router router = Router.router(vertx);

        //处理echo请求
        router.get("/echo").handler(context -> {
            HttpServerRequest request = context.request();
            //请求
            String message = request.getParam("message");
            //响应
            HttpServerResponse response = request.response();
            response.end("Hello," + message);
        });

        //创建http server

        vertx.createHttpServer().requestHandler(router::accept).listen(8080);//监听8080端口
    }

}
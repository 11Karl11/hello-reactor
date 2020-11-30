package com.karl.reactor.reactiveweb;

import com.sun.net.httpserver.HttpServer;
import org.checkerframework.checker.units.qual.A;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


import static com.karl.reactor.utils.Util1.println;


/**
 * 异步+非阻塞servlet
 * @author karl xie
 * Created on 2020-11-30 16:52
 */

@WebServlet(name="async-non-blocking",urlPatterns = "/async-non-blocking",asyncSupported = true)
public class AsyncNonBlockingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //开启异步上下文
        AsyncContext asyncContext = req.startAsync();
        //非阻塞回调
        asyncContext.addListener(new AsyncListener() {
            @Override
            public void onComplete(AsyncEvent asyncEvent) throws IOException {
                ServletResponse response = asyncContext.getResponse();
                response.getWriter().println("hello world");
                println("异步上下文执行完毕");
            }

            @Override
            public void onTimeout(AsyncEvent asyncEvent) throws IOException {

            }

            @Override
            public void onError(AsyncEvent asyncEvent) throws IOException {

            }

            @Override
            public void onStartAsync(AsyncEvent asyncEvent) throws IOException {

            }
        });

        //完成操作
        asyncContext.complete();
    }
}
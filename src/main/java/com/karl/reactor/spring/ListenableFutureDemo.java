package com.karl.reactor.spring;

import com.karl.reactor.utils.Util;
import org.springframework.core.task.AsyncListenableTaskExecutor;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * @author karl xie
 */
public class ListenableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        SimpleAsyncTaskExecutor executor = new SimpleAsyncTaskExecutor("ListenableFutureDemo-");


        ListenableFuture<Integer> future = executor.submitListenable(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println(Thread.currentThread().getName());
                return 1;
            }
        });

        //添加callback
        future.addCallback(new ListenableFutureCallback<Integer>() {
            @Override
            public void onFailure(Throwable ex) {
                Util.printf(ex);
            }

            @Override
            public void onSuccess(Integer result) {
                Util.printf(result);
            }
        });

        future.addCallback(new ListenableFutureCallback<Integer>() {
            @Override
            public void onFailure(Throwable ex) {
                Util.printf(ex);
            }

            @Override
            public void onSuccess(Integer result) {
                Util.printf(result);
            }
        });

       future.get();


    }
}
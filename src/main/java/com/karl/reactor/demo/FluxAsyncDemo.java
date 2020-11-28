package com.karl.reactor.demo;

import com.google.common.collect.Lists;
import com.karl.reactor.utils.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

/**
 * 异步操作
 *
 * @author karl xie
 */
public class FluxAsyncDemo {
    public static void main(String[] args) throws InterruptedException {

        //当前线程执行
        // Flux.range(0, 10)
        //         .publishOn(Schedulers.immediate())
        //         .subscribe(Util::printf);



        //单线程异步执行
        // Flux.range(0, 10)
        //         .publishOn(Schedulers.single())
        //         .subscribe(Util::printf);


        //弹性线程池异步执行
        // Flux.range(0, 10)
        //         .publishOn(Schedulers.elastic())
        //         .subscribe(Util::printf);

        //并行执行
        Flux.range(0, 10)
                .publishOn(Schedulers.parallel())
                .subscribe(Util::printf);
        //强制让主线程执行完毕
        Thread.currentThread().join(1000L);



    }
}
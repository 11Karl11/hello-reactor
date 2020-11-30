package com.karl.reactor.rxjava;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author karl xie
 */
public class RXJavaDemo {

    public static void main(String[] args) throws InterruptedException {
        RXJavaDemo rxJavaDemo = new RXJavaDemo();
        reactorMode(rxJavaDemo);

        sleep(1000l);

    }


    private static void reactorMode(RXJavaDemo rxJavaDemo) {
        long start = System.currentTimeMillis();
        //publish
        //Flowable.just(rxJavaDemo.queryA());
        //just方法是完全调用queryA()+queryB()>=阻塞模式
        // Observable<Integer[]> observableA = Observable.just(rxJavaDemo.queryA());
        // Observable<Integer[]> observableB = Observable.just(rxJavaDemo.queryB());

        //流水梳理
        //开发人员不需关注并发或者线程池
        //流式处理机制，类似Stream->Flowable
        Observable<Integer[]> observableA = Observable.fromCallable(RXJavaDemo::queryA);
        // observableA.subscribe();
        observableA
                .subscribeOn(Schedulers.newThread())//决定同步、异步
                .doOnNext(value -> {
                    //数据消费正常逻辑
                })
                .doOnError(e -> {
                    //数据消费异常逻辑
                })
                .doOnComplete(() -> {
                    //执行结束逻辑

                });
        Observable<Integer[]> observableB = Observable.fromCallable(RXJavaDemo::queryB);
        //observableB.subscribe();
        observableB.subscribeOn(Schedulers.newThread()).subscribe();

        long costTime = System.currentTimeMillis() - start;
        System.out.println("reactorMode costTime: " + costTime);
    }


    private static Integer[] queryA() {
        sleep(100L);
        System.out.printf("Thread[%s] queryA()\n", Thread.currentThread().getName());
        return of(1, 2, 3);
    }

    private static Integer[] queryB() {
        sleep(200L);
        System.out.printf("Thread[%s] queryB()\n", Thread.currentThread().getName());
        return of(4, 5, 6);

    }

    private static <T> T[] of(T... values) {
        return values;
    }

    private static void sleep(Long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
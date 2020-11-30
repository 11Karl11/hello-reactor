package com.karl.reactor.reactiveweb;

import java.util.Observable;

import static com.karl.reactor.utils.Util1.println;

/**
 * 同步+非阻塞
 * @author karl xie
 */
public class ObserverPattenDemo {


    public static void main(String[] args) {

        //同步非阻塞基本上采用callback形式
        //数据发布
        //当前实现：同步+非阻塞
        MyObservable observable = new MyObservable();


        observable.addObserver((o, value) -> {
            println("1收到数据更新： " + value);
        });


        observable.addObserver((o, value) -> {
            println("2收到数据更新： " + value);
        });

        observable.addObserver((o, value) -> {
            println("3收到数据更新： " + value);
        });

        println("observable 通知所有观察者");
        //说明已经改变
        observable.setChanged();
        observable.notifyObservers("Hello World");//发布数据-push data

    }

    public static class MyObservable extends Observable {

        public synchronized void setChanged() {
            super.setChanged();
        }
    }
}
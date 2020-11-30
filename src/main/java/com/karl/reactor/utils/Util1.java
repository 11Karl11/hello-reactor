package com.karl.reactor.utils;

/**
 * @author karl xie
 * Created on 2020-11-30 16:00
 */
public class Util1 {

    public static void println(Object value) {
        String name = Thread.currentThread().getName();
        System.out.printf("[线程:%s]%s\n", name, value);

    }
}
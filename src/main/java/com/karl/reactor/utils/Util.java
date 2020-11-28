package com.karl.reactor.utils;

/**
 * @author karl xie
 */
public class Util {

    public static void printf(Object msg) {
        System.out.printf("[Thread : %s ] : %s\n", Thread.currentThread().getName(), String.valueOf(msg));
    }
}
package com.karl.reactor.demo;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author karl xie
 */
public class IteratorDemo {


    public static void main(String[] args) {

        ArrayList<Integer> values = Lists.newArrayList(1, 2, 3, 4, 5);

        Iterator<Integer> iterator = values.iterator();
        while (iterator.hasNext()){
            Integer value = iterator.next();//主动获取数据
            System.out.println(value);
        }
    }
}
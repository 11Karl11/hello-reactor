package com.karl.reactor.demo;

import com.karl.reactor.utils.Util;
import reactor.core.publisher.Flux;

/**
 * @author karl xie
 */
public class FluxAPIDemo {

    public static void main(String[] args) {


        Flux.generate(() -> 0, (value, sink) -> {
            if (value == 3) {
                sink.complete();//主动完成
            } else {
                sink.next("value= " + value);
            }
            return value + 1;
        }).subscribe(Util::printf,Util::printf,()->{
            Util.printf("订阅成功");
        });
    }
}
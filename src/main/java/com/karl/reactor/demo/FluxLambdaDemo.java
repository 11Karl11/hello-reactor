package com.karl.reactor.demo;

import com.karl.reactor.utils.Util;
import reactor.core.publisher.Flux;

import java.util.Random;

/**
 * @author karl xie
 */
public class FluxLambdaDemo {

    public static void main(String[] args) {
        Flux<Integer> flux = Flux.just(1, 2, 3);
        Random random = new Random();
        //订阅并且处理(控制台输出)
        flux.subscribe(Util::printf);

        flux.map(v -> {
            if (random.nextInt(4) == 3) {
                throw new RuntimeException();
            }
            return v + 1;
        }).subscribe(
                Util::printf,//处理数据 onNext()
                Util::printf, //处理异常 onError()
                () -> {
                    Util.printf("订阅完成");
                }
        );


    }
}
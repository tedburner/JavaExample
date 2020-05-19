package com.example.reactive.reactive_design.chapter03.rxjava;

import io.reactivex.Observable;

/**
 * @author: lingjun.jlj
 * @date: 2019-01-10 22:30
 * @description:
 */
public class RxJavaExample {
    public void observe(String[] strings) {
        Observable.fromArray(strings).subscribe((s) -> System.out.println("Received " + s));
    }
}

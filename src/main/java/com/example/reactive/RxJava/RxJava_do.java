package com.example.reactive.RxJava;

import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * @author: lingjun.jlj
 * @date: 2019/4/2 20:34
 * @description: do 操作符
 */
public class RxJava_do {

    public static void main(String[] args) {
        Observable.just("Hello")
                .doOnNext(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        System.out.println("doOnNext: " + s);
                    }
                }).doAfterNext(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println("doAferNext:" + s);
            }
        }).doOnComplete(new Action() {
            @Override
            public void run() throws Exception {
                System.out.println("doOnComplete:");
            }
        })
                //订阅之后回调的方法
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        System.out.println("doOnSubscribe:");
                    }
                }).doAfterTerminate(new Action() {
            @Override
            public void run() throws Exception {
                System.out.println("doAfterTerminate()");
            }
        })
                .doFinally(new Action() {
                    @Override
                    public void run() throws Exception {
                        System.out.println("doFinally()");
                    }
                })
                //Observable没法涉一次数据就会触发这个回调，不仅包括onNext,还包括onError和onCompleted
                .doOnEach(new Consumer<Notification<String>>() {
                    @Override
                    public void accept(Notification<String> stringNotification) throws Exception {
                        System.out.println("doOnEach: " + (stringNotification.isOnNext() ? "onNext" : stringNotification.isOnComplete()));
                    }
                }).doOnLifecycle(new Consumer<Disposable>() {
            @Override
            public void accept(Disposable disposable) throws Exception {
                System.out.println("doOnLifecycle: " + disposable.isDisposed());
            }
        }, new Action() {
            @Override
            public void run() throws Exception {
                System.out.println("doOnLifecycle run....");
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println("收到消息：" + s);
            }
        });
    }
}

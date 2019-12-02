package com.example.reactive.RxJava;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * @author: lingjun.jlj
 * @date: 2019/4/2 20:16
 * @description:
 */
public class HelloWorld {

    public static void main(String[] args) {
        //just()是RxJava的创建操作符
        Observable.just("Hello World")
                .subscribe(System.out::println);

        System.out.println("====================================");

        //subscribe有多个重载的方法
        Observable.just("Hello RxJava")
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        System.out.println(s);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        System.out.println(throwable.getMessage());
                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        System.out.println("onComplete()");
                    }
                });

        System.out.println("============================================");
        //使用Observer作为观察者
        Observable.just("Hello RxJava2")
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {
                        System.out.println("subscribe");
                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println(s);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println(throwable.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete()");
                    }
                });
    }
}

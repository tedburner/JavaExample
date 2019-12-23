package com.example.common;

import java.util.concurrent.TimeUnit;

/**
 * @author: lingjun.jlj
 * @date: 2019/12/23 09:20
 * @description:
 */
public class HookTest {

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("Java 钩子启动....");
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("退出 Java Hook ...");
            }
        });
    }
}

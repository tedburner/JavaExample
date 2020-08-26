package com.example.test;

/**
 * @author: lingjun.jlj
 * @date: 2020/8/26 21:26
 * @description: 线程交替打印奇偶数
 */
public class AlternatePrintingNotifyAndWait {

    private static Object monitor = new Object();
    private static int i = 0;

    public static void main(String[] args) {
        //奇数线程
        new Thread(() -> {
            while (true) {
                synchronized (monitor) {
                    i++;
                    //奇数
                    if (i % 2 != 0) {
                        if (i > 100) {
                            return;
                        }
                        //唤醒线程
                        monitor.notify();
                        System.out.println("奇数线程：" + i);
                        try {
                            //线程等待
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();

        //偶数线程
        new Thread(() -> {
            while (true) {
                synchronized (monitor) {
                    i++;
                    //奇数
                    if (i % 2 == 0) {
                        if (i > 100) {
                            return;
                        }
                        //唤醒线程
                        monitor.notify();
                        System.out.println("偶数线程：" + i);
                        try {
                            //线程等待
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }

}

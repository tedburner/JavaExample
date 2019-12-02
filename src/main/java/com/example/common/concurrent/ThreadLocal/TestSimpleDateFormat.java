package com.example.common.concurrent.ThreadLocal;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author lingjun.jlj
 * @date 2017-12-26
 * SimpleDateFormat在多线程下是不安全的
 * 方法1：每次使用时new一个新的SimpleDateFormat，但是这样会浪费资源
 * 方法2：加synchronized（sdf）,但是使用同步意味着多个线程要竞争锁，在高并发场景下会导致系统响应性能下降。
 * 方法3：如下使用ThreadLocal。
 * 源码分析： parsedDate = calb.establish(calendar).getTime();里面的 cal.clear();
 **/
public class TestSimpleDateFormat {
    //(1)创建单例实例
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    // (1)创建threadlocal实例
    static ThreadLocal<DateFormat> safeSdf = new ThreadLocal<DateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };
    public static void main(String[] args) {
        //(2)创建多个线程，并启动
        for (int i = 0; i < 100; ++i) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    try {//(3)使用单例日期实例解析文本
                        //System.out.println(safeSdf.get().parse("2017-12-13 15:17:27"));
                        System.out.println(sdf.parse("2018-05-14 11:00:00"));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();//(4)启动线程
        }
    }
}

package com.example.test.trace;

import com.alibaba.fastjson.JSON;

import java.util.concurrent.TimeUnit;

/**
 * @author: lingjun.jlj
 * @date: 2021/1/14 09:20
 * @description: 程序耗时统计
 */
public class TraceHolderTest {

    public static void main(String[] args) {
        TraceWatch traceWatch = new TraceWatch();

        TraceHolder.run(traceWatch, "function1", i -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        String result = TraceHolder.run(traceWatch, "function2", () -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                return "YES";
            } catch (Exception e) {
                e.printStackTrace();
                return "NO";
            }
        });
        System.out.println("function2 执行结果：" + result);

        TraceHolder.run(traceWatch, "function3", i -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        System.out.println(JSON.toJSONString(traceWatch.getTaskMap()));
    }

}

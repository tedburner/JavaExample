package com.example.test.trace;

/**
 * @author: lingjun.jlj
 * @date: 2021/1/14 09:24
 * @description:
 */
public class TimeUtils {
    /**
     * @return 当前毫秒数
     */
    public static long nowMs() {
        return System.currentTimeMillis();
    }

    /**
     * 当前毫秒与起始毫秒差
     *
     * @param startMillis 开始纳秒数
     * @return 时间差
     */
    public static long diffMs(long startMillis) {
        return diffMs(startMillis, nowMs());
    }

    /**
     * 当前毫秒与起始毫秒差
     *
     * @param startMillis 开始纳秒数
     * @return 时间差
     */
    public static long diffMs(long startMillis, long nowMs) {
        return nowMs - startMillis;
    }

}

package com.example.spring.aop.monitor;

/**
 * @author lingjun.jlj
 * @date: 2018/5/9
 * @Description:
 */
public class MonitorSession {

    private static ThreadLocal<MethodMonitor> monitorThreadLocal = new ThreadLocal<>();

    public static void begin(String method) {
        MethodMonitor logger = new MethodMonitor(method);
        monitorThreadLocal.set(logger);
    }

    public static void end() {
        MethodMonitor logger = monitorThreadLocal.get();
        logger.log();
    }
}

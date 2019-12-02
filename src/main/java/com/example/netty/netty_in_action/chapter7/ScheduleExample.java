package com.example.netty.netty_in_action.chapter7;

import io.netty.channel.Channel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author: Arthas
 * @date: 2019-05-08 22:48
 * @description: 使用定时线程池
 */
public class ScheduleExample {

    private static final Channel CHANNEL_FROM_SOMEWHERE = new NioSocketChannel();

    public static void scheduledExecutor() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);

        ScheduledFuture<?> future = executor.schedule(() -> {
            System.out.println("60 seconds later");
        }, 60, TimeUnit.SECONDS);

        executor.shutdown();
    }

    public static void scheduleViaEventLoop() {
        Channel channel = CHANNEL_FROM_SOMEWHERE;
        ScheduledFuture<?> future = channel.eventLoop()
                .schedule(() -> {
                    System.out.println("60 seconds later");
                }, 60, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        scheduledExecutor();
        System.out.println("--------------------");
        scheduleViaEventLoop();
    }
}

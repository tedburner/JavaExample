package com.example.netty.netty_in_action.chapter7;

import java.util.Collections;
import java.util.List;

/**
 * @author: Arthas
 * @date: 2019-05-08 22:59
 * @description:
 */
public class EventLoopExample {

    public static void executeTaskInEventLoop() {
        boolean terminated = true;
        //...
        while (!terminated) {
            List<Runnable> readyEvents = blockUntilEventsReady();
            for (Runnable ev: readyEvents) {
                ev.run();
            }
        }
    }

    private static final List<Runnable> blockUntilEventsReady() {
        return Collections.<Runnable>singletonList(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        executeTaskInEventLoop();
    }
}

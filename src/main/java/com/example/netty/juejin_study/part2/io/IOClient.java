package com.example.netty.juejin_study.part2.io;

import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: lingjun.jlj
 * @date: 2019-01-10 16:48
 * @description:
 */
public class IOClient {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1", 8000);

                while (true) {
                    try {
                        socket.getOutputStream().write((sdf.format(new Date()) + ": hello world").getBytes());
                        //每隔2秒想服务端发送消息
                        Thread.sleep(2000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}

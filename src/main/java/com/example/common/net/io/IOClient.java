package com.example.common.net.io;

import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/8 16:55
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
                        socket.getOutputStream().write(( sdf.format(new Date())+ ":Hello World").getBytes());
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

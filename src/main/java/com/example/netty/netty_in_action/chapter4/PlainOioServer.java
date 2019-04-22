package com.example.netty.netty_in_action.chapter4;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * @author: Arthas
 * @date: 2019-04-20 14:15
 * @description:
 */
public class PlainOioServer {

    public void serve(int port) throws Exception {
        //将服务器绑定到指定端口
        final ServerSocket socket = new ServerSocket(port);
        try {
            for (; ; ) {
                //接受连接
                final Socket clientSocket = socket.accept();
                System.out.println("Accepted  connection from " + clientSocket);
                new Thread(() -> {
                    OutputStream out;
                    try {
                        out = clientSocket.getOutputStream();
                        //将消息写给已连接的客户端
                        out.write("Hi！\r\n".getBytes(Charset.forName("UTF-8")));
                        out.flush();
                        clientSocket.close();


                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            clientSocket.close();

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

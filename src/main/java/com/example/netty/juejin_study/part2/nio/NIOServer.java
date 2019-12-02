package com.example.netty.juejin_study.part2.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * @author: Arthas
 * @date: 2019-01-10 17:06
 * @description:
 */
public class NIOServer {

    public static void main(String[] args) throws IOException {
        Selector serverSelector = Selector.open();
        Selector clientSelector = Selector.open();

        new Thread(() -> {
            try {
                //对应IO编程中服务端的启动
                ServerSocketChannel listenerChannel = ServerSocketChannel.open();
                listenerChannel.socket().bind(new InetSocketAddress(8000));
                listenerChannel.configureBlocking(false);
                listenerChannel.register(serverSelector, SelectionKey.OP_ACCEPT);

                while (true) {
                    //监听是否有新的连接，这里的1指的是阻塞时间 1ms
                    if (serverSelector.select(1) > 0) {
                        Set<SelectionKey> set = serverSelector.selectedKeys();
                        Iterator<SelectionKey> keyIterator = set.iterator();

                        while (keyIterator.hasNext()) {
                            SelectionKey key = keyIterator.next();

                            if (key.isAcceptable()) {
                                try {
                                    //没来一个新连接，不需要创建爱你一个线程，而是直接注册到 clientServer上
                                    SocketChannel clientChannel = ((ServerSocketChannel) key.channel()).accept();
                                    clientChannel.configureBlocking(false);
                                    clientChannel.register(clientSelector, SelectionKey.OP_READ);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                } finally {
                                    keyIterator.remove();
                                }
                            }
                        }
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                while (true){
                    //批量轮询是否有哪些数据刻度，这里的1 指的是阻塞时间 1ms
                    if (clientSelector.select(1)>0){
                        Set<SelectionKey> set = clientSelector.selectedKeys();
                        Iterator<SelectionKey> keyIterator = set.iterator();

                        while (keyIterator.hasNext()){
                            SelectionKey key = keyIterator.next();

                            try {
                                SocketChannel clientChannel = (SocketChannel) key.channel();

                                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                                //面向Buffer
                                clientChannel.read(byteBuffer);
                                byteBuffer.flip();

                                System.out.println(Charset.defaultCharset().newDecoder().decode(byteBuffer)
                                        .toString());
                            }finally {
                                keyIterator.remove();
                                key.interestOps(SelectionKey.OP_READ);
                            }
                        }
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}

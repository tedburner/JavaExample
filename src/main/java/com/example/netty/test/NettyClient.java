package com.example.netty.test;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/8 17:43
 * @description:
 */
public class NettyClient {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public static void main(String[] args) throws InterruptedException {
        Bootstrap bootstrap = new Bootstrap();
        NioEventLoopGroup group = new NioEventLoopGroup();

        bootstrap
                //指定线程模型
                .group(group)
                //指定 io 类型为 NIO
                .channel(NioSocketChannel.class)
                // io 处理逻辑
                .handler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel channel) throws Exception {
                        channel.pipeline().addLast(new StringEncoder());
                    }
                });
        // 建立连接
        Channel channel = bootstrap.connect("127.0.0.1", 8200).channel();
        while (true) {
            channel.writeAndFlush(sdf.format(new Date()) + " : Hello World!");
            Thread.sleep(2000);
        }
    }
}

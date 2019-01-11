package com.example.netty.juejin_study.part2.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;

/**
 * @author: Arthas
 * @date: 2019-01-10 17:43
 * @description:
 */
public class NettyServer {

    public static void main(String[] args) {
        //引导类，引导我们进行服务端的启动工作
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        //boss 对应 IOServer 中接收连接线程，主要负责创建新的连接
        NioEventLoopGroup boss = new NioEventLoopGroup();
        //boss 对应 IOServer 中的读取数据的线程，主要用户读取数据以及业务逻辑处理
        NioEventLoopGroup worker = new NioEventLoopGroup();

        serverBootstrap
                .group(boss, worker)
                .channel(NioServerSocketChannel.class) //IO模型选择 NIO
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    protected void initChannel(NioSocketChannel channel) {
                        channel.pipeline().addLast(new StringDecoder());
                        channel.pipeline().addLast(new SimpleChannelInboundHandler<String>() {
                            @Override
                            protected void channelRead0(ChannelHandlerContext ctx, String msg) {
                                System.out.println(msg);
                            }
                        });
                    }
                })
                .bind(8100);
    }
}

package com.example.netty.netty_in_action.chapter2;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * @author: lingjun.jlj
 * @Date: 2018/6/26 10:03
 * @Description:
 */
public class EchoServer {

    private final int port;

    public EchoServer(int port) {
        this.port = port;
    }


    public static void main(String[] args) throws Exception {

        int port = 8080;
        new EchoServer(port).start();
    }

    public void start() throws Exception {
        //创建 EventLoopGroup
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(group)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(port))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel channel) throws Exception {
                            //绑定服务端 server handler
                            channel.pipeline().addLast(new EchoServerHandler());
                        }
                    });
            //异步的绑定服务器；调用sync()方法阻塞等待知道绑定完成
            ChannelFuture future = bootstrap.bind().sync();
            //获取channel的closeFuture，并且阻塞当前线程直到完成
            future.channel().closeFuture().sync();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭EventLoopGroup,释放所有资源
            group.shutdownGracefully().sync();
        }

    }
}

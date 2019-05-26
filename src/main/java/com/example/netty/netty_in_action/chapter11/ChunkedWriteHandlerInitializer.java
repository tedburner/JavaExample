package com.example.netty.netty_in_action.chapter11;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslHandler;
import io.netty.handler.stream.ChunkedStream;
import io.netty.handler.stream.ChunkedWriteHandler;

import java.io.File;
import java.io.FileInputStream;

/**
 * @author: Arthas
 * @date: 2019-05-23 22:33
 * @description: 使用ChunkedStream传输文件
 */
public class ChunkedWriteHandlerInitializer extends ChannelInitializer<Channel> {
    private final File file;
    private final SslContext sslCtx;

    public ChunkedWriteHandlerInitializer(File file, SslContext sslCtx) {
        this.file = file;
        this.sslCtx = sslCtx;
    }

    @Override
    protected void initChannel(Channel ch) throws Exception {
        ch.pipeline()
                .addLast(new SslHandler(sslCtx.newEngine(ch.alloc())))
                .addLast(new ChunkedWriteHandler())
                .addLast(new WriteStreamHandler());
    }

    public final class WriteStreamHandler
            extends ChannelInboundHandlerAdapter {

        @Override
        public void channelActive(ChannelHandlerContext ctx)
                throws Exception {
            super.channelActive(ctx);
            ctx.writeAndFlush(
                    new ChunkedStream(new FileInputStream(file)));
        }
    }
}

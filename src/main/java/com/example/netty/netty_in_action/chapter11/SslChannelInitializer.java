package com.example.netty.netty_in_action.chapter11;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslHandler;

import javax.net.ssl.SSLEngine;

/**
 * @author: lingjun.jlj
 * @date: 2019-05-20 23:10
 * @description: 添加SSL/TLS支持
 */
public class SslChannelInitializer extends ChannelInitializer<Channel> {

    private final SslContext context;
    private final boolean startTls;

    public SslChannelInitializer(SslContext context, boolean startTls) {
        this.context = context;
        this.startTls = startTls;
    }

    @Override
    protected void initChannel(Channel channel) throws Exception {
        SSLEngine engine = context.newEngine(channel.alloc());
        channel.pipeline()
                .addFirst("ssl", new SslHandler(engine, startTls));
    }
}

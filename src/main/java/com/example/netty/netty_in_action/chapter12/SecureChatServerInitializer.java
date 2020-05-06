package com.example.netty.netty_in_action.chapter12;

import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslHandler;

import javax.net.ssl.SSLEngine;

/**
 * @author: Arthas
 * @date: 2019-05-30 22:14
 * @description:
 */
public class SecureChatServerInitializer extends ChatServerInitializer {

    private final SslContext context;


    public SecureChatServerInitializer(ChannelGroup group, SslContext context) {
        super(group);
        this.context = context;
    }

    @Override
    protected void initChannel(Channel ch) throws Exception {
        super.initChannel(ch);
        SSLEngine engine = context.newEngine(ch.alloc());
        engine.setUseClientMode(false);
        //将SslHandler 添加到ChannelPipeline
        ch.pipeline().addFirst(new SslHandler(engine));
    }
}

package com.example.netty.netty_in_action.chapter11;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @author: lingjun.jlj
 * @date: 2019-05-21 22:47
 * @description: 聚合Http 消息
 */
public class HttpAggregatorInitializer extends ChannelInitializer<Channel> {

    private final boolean isClient;

    public HttpAggregatorInitializer(boolean isClient) {
        this.isClient = isClient;
    }

    @Override
    protected void initChannel(Channel channel) throws Exception {
        ChannelPipeline pipeline = channel.pipeline();
        if (isClient) {
            pipeline.addLast("coder", new HttpClientCodec());
        } else {
            pipeline.addLast("coder", new HttpServerCodec());
        }
        pipeline.addLast("aggregator", new HttpObjectAggregator(512 * 1024));
    }
}

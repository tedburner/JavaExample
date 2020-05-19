package com.example.netty.netty_in_action.chapter11;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpContentCompressor;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @author: lingjun.jlj
 * @date: 2019-05-21 22:55
 * @description: HTTP压缩
 */
public class HttpCompressionInitializer extends ChannelInitializer<Channel> {
    private final boolean isClient;

    public HttpCompressionInitializer(boolean isClient) {
        this.isClient = isClient;
    }

    @Override
    protected void initChannel(Channel channel) throws Exception {
        ChannelPipeline pipeline = channel.pipeline();
        if (isClient) {
            pipeline.addLast("codec", new HttpClientCodec())
                    .addLast("decompressor", new HttpContentCompressor());
        } else {
            pipeline.addLast("codec", new HttpServerCodec())
                    .addLast("decompressor", new HttpContentCompressor());
        }
    }
}

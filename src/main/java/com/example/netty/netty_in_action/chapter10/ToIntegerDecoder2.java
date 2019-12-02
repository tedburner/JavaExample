package com.example.netty.netty_in_action.chapter10;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * @author: Arthas
 * @date: 2019-05-19 13:03
 * @description: ReplayingDecoder 解码器
 */
public class ToIntegerDecoder2 extends ReplayingDecoder {

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf in, List<Object> out) throws Exception {
        //从入站ByteBuf中读取一个int，并将其添加到解码消息的List中
        out.add(in.readInt());
    }
}

package com.example.netty.netty_in_action.chapter10;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @author: Arthas
 * @date: 2019-05-19 13:01
 * @description: 字节解码器
 */
public class ToIntegerDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf in, List<Object> out) throws Exception {
        //检查是否至少有4个字节
        if (in.readableBytes() > 4) {
            out.add(in.readInt());
        }
    }
}

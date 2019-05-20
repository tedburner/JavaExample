package com.example.netty.netty_in_action.chapter10;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author: Arthas
 * @date: 2019-05-19 13:22
 * @description: 编码器, Short -> ByteBuf
 */
public class ShortToByteEncoder extends MessageToByteEncoder<Short> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Short o, ByteBuf out) throws Exception {
        out.writeShort(o);
    }
}

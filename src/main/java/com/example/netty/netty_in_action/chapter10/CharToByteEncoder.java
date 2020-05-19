package com.example.netty.netty_in_action.chapter10;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author: lingjun.jlj
 * @date: 2019-05-19 17:02
 * @description:
 */
public class CharToByteEncoder extends MessageToByteEncoder<Character> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Character character, ByteBuf byteBuf) throws Exception {
        byteBuf.writeChar(character);
    }
}

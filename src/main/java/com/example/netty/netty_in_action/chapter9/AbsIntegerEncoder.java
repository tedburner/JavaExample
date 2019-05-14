package com.example.netty.netty_in_action.chapter9;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

/**
 * @author: Arthas
 * @date: 2019-05-14 22:23
 * @description:
 */
public class AbsIntegerEncoder extends MessageToMessageEncoder<ByteBuf> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> out) throws Exception {
        while (byteBuf.readableBytes() >= 4) {
            int value = Math.abs(byteBuf.readInt());//从输入的ByteBuf中读取下一个整数，并且计算器绝对值
            out.add(value);//将该整数写入到编码消息的list中
        }
    }
}

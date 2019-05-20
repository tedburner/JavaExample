package com.example.netty.netty_in_action.chapter10;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.TooLongFrameException;

import java.util.List;

/**
 * @author: Arthas
 * @date: 2019-05-19 13:15
 * @description: 安全使用解码器，如果太长，抛出异常
 */
public class SafeByteToMessageDecoder extends ByteToMessageDecoder {

    private static final int MAX_FRAME_SZIE = 1024;

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf in, List<Object> out) throws Exception {
        int readable = in.readableBytes();
        if (readable > MAX_FRAME_SZIE) {
            //跳过所有可读字节
            in.skipBytes(readable);
            throw new TooLongFrameException("Frame too big!");
        }
    }
}

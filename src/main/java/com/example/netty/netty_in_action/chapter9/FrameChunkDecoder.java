package com.example.netty.netty_in_action.chapter9;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.TooLongFrameException;

import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2019-05-14 23:06
 * @description:
 */
public class FrameChunkDecoder extends ByteToMessageDecoder {

    private final int maxFrameSize;

    public FrameChunkDecoder(int maxFrameSize){
        this.maxFrameSize = maxFrameSize;
    }


    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf in, List<Object> out) throws Exception {
        int  readableBytes = in.readableBytes();
        if (readableBytes > maxFrameSize){
            in.clear();
            throw new TooLongFrameException();
        }
        ByteBuf buf = in.readBytes(readableBytes);
        out.add(buf);
    }
}

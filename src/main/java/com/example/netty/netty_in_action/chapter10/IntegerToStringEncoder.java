package com.example.netty.netty_in_action.chapter10;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

/**
 * @author: Arthas
 * @date: 2019-05-19 13:24
 * @description: 编码器蒋每个出站Integer 的String 表示添加到List
 */
public class IntegerToStringEncoder extends MessageToMessageEncoder<Integer> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Integer msg, List<Object> out) throws Exception {
        out.add(String.valueOf(msg));
    }
}

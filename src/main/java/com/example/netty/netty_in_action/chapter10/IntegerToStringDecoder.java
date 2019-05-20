package com.example.netty.netty_in_action.chapter10;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

/**
 * @author: Arthas
 * @date: 2019-05-19 13:13
 * @description: Integer转化成String
 */
public class IntegerToStringDecoder extends MessageToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, Object o, List list) throws Exception {
        list.add(String.valueOf(o));
    }
}

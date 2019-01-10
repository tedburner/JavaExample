package com.example.netty.juejin_study.part6.client;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;
import java.util.Date;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/11 16:01
 * @description:
 */
public class FirstClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        System.out.println(new Date() + " : 客户端写数据");
        //获取数据
        ByteBuf buf = getByteBuf(ctx);

        //写数据
        ctx.channel().writeAndFlush(buf);
    }

    private ByteBuf getByteBuf(ChannelHandlerContext ctx) {
        byte[] bytes = "你好，Netty!".getBytes(Charset.forName("utf-8"));

        ByteBuf buf = ctx.alloc().buffer();

        buf.writeBytes(bytes);

        return buf;

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println(new Date() + ": 客户端读取到数据 -> " + byteBuf.toString(Charset.forName("utf-8")));

    }

}

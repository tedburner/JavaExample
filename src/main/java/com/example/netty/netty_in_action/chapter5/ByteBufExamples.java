package com.example.netty.netty_in_action.chapter5;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.nio.ByteBuffer;
import java.util.Random;

import static io.netty.channel.DummyChannelHandlerContext.DUMMY_INSTANCE;

/**
 * @author: Arthas
 * @date: 2019-04-22 22:59
 * @description: ByteBuf 事例
 */
public class ByteBufExamples {

    private final static Random random = new Random();
    private static final ByteBuf BYTE_BUF_FROM_SOMEWHERE = Unpooled.buffer(1024);
    private static final Channel CHANNEL_FROM_SOMEWHERE = new NioSocketChannel();
    private static final ChannelHandlerContext CHANNEL_HANDLER_CONTEXT_FROM_SOMEWHERE = DUMMY_INSTANCE;

    /**
     * 堆缓冲区
     */
    public void headBuffer() {
        ByteBuf headBuf = BYTE_BUF_FROM_SOMEWHERE;
        //检查ByteBuf是否有一个支撑数组
        if (headBuf.hasArray()) {
            byte[] array = headBuf.array();
            //获取数组的引用
            int offset = headBuf.arrayOffset() + headBuf.readerIndex();
            //获取可读字节数
            int length = headBuf.readableBytes();
            handleArray(array, offset, length);


        }
    }

    /**
     * 直接缓冲区
     */
    public void directBuffer() {
        ByteBuf directBuf = BYTE_BUF_FROM_SOMEWHERE;
        if (!directBuf.hasArray()) {
            int length = directBuf.readableBytes();
            byte[] array = new byte[length];
            directBuf.getBytes(directBuf.readerIndex(), array);
            handleArray(array, 0, length);
        }
    }


    /**
     * 复合缓冲区
     * Composite buffer pattern using ByteBuffer
     * 使用 ByteBuffer的复合缓冲区模式
     */
    public void byteBufferComposite(ByteBuffer header, ByteBuffer body) {
        ByteBuffer[] message = new ByteBuffer[]{header, body};
        ByteBuffer msg = ByteBuffer.allocate(header.remaining() + body.remaining());
        msg.put(header);
        msg.put(body);
        msg.flip();

    }

    /**
     * 使用CompositeByteBuf的复合缓冲区模式
     */
    public void byteBufComposite() {
        CompositeByteBuf messageBuf = Unpooled.compositeBuffer();
        ByteBuf headerBuf = BYTE_BUF_FROM_SOMEWHERE;
        ByteBuf bodyBuf = BYTE_BUF_FROM_SOMEWHERE;

        messageBuf.addComponents(headerBuf, bodyBuf);

        //删除位于索引位置为0（第一个组件）的ByteBuf
        messageBuf.removeComponent(0);
        for (ByteBuf buf : messageBuf) {
            System.out.println(buf.toString());
        }
    }

    /**
     * 访问CompositeByteBuf中的数据
     * Accessing the data in a CompositeByteBuf
     */
    public static void byteBufCompositeArray() {
        CompositeByteBuf compBuf = Unpooled.compositeBuffer();
        //获取可读字节数
        int length = compBuf.readableBytes();
        //分配一个具有可读字节数长度的数组
        byte[] array = new byte[length];
        //将字节读到该数组中
        compBuf.getBytes(compBuf.readerIndex(), array);
        handleArray(array, 0, array.length);
    }

    private static void handleArray(byte[] array, int offset, int len) {
    }

    public static void main(String[] args) {

    }

}

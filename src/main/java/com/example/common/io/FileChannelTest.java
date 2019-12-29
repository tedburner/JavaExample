package com.example.common.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author: Arthas
 * @date: 2019-01-22 10:22
 * @description: FileChannel 读写 堆内内存
 */
public class FileChannelTest {

    public static void main(String[] args) throws IOException {
        //使用 FileChannel
        FileChannel fileChannel = new RandomAccessFile(new File("/Users/jianglingjun/Document/temp/db.txt"), "rw")
                .getChannel();

        //写
        byte[] data = new byte[4096];
        long position = 1024L;
        //指定 position 位置写入 4kb 的数据
        fileChannel.write(ByteBuffer.wrap(data), position);
        //从当前文件指针位置写入 4KB 的数据
        fileChannel.write(ByteBuffer.wrap(data));

        //读
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        //指定 position 位置读取 4KB 数据
        fileChannel.read(buffer, position);
        //从当前位置指针位置读取 4KB 数据
        fileChannel.read(buffer);


    }
}

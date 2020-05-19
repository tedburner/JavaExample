package com.example.common.io.mmap;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author: lingjun.jlj
 * @date: 2019-01-18 16:47
 * @description: 零拷贝 mmap 测试类
 */
public class MMapTest {

    public static void main(String[] args) throws IOException {
        //使用 FileChannel
        FileChannel fileChannel = new RandomAccessFile(new File("db.data"), "rw").getChannel();

        //获取 MMAP 的方式
        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, fileChannel.size());

        //写
        byte[] data = new byte[4];
        int position = 8;
        //从当前 mmap 指针位置写入4b数据
        mappedByteBuffer.put(data);

        //指定 position 位置写入 4b 数据
        MappedByteBuffer subBuffer = (MappedByteBuffer) mappedByteBuffer.slice();
        subBuffer.position(position);
        subBuffer.put(data);

        //读
        byte[] read_date = new byte[4];
        //从当前位置读取数据
        mappedByteBuffer.get(read_date);

        MappedByteBuffer readBuffer = (MappedByteBuffer) mappedByteBuffer.slice();
        readBuffer.position(position);
        readBuffer.get(read_date);


    }
}

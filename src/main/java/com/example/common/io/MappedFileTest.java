package com.example.common.io;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author: lingjun.jlj
 * @date: 2019/12/29 17:04
 * @description: MappedFile 内存映射文件，比普通的文件操作访问文件要快，另外一个优势是能够加载普通方式无法访问的大文件。
 * 缺点：增加页面错误的可能
 */
public class MappedFileTest {
    private static int count = 10485760; // 10 MB

    public static void main(String[] args) throws IOException {

        RandomAccessFile randomAccessFile = new RandomAccessFile("/Users/jianglingjun/Document/temp/test.txt", "rw");
        //映射一个文件到内存中
        MappedByteBuffer out = randomAccessFile.getChannel()
                .map(FileChannel.MapMode.READ_WRITE, 0, count);

        //write into memory mapped file
        for (int i = 0; i < count; i++) {
            out.put((byte) 'A');
        }
        System.out.println("Write to Memory Mapped File is completed");

        //reading from memory file in java
        for (int i = 0; i < count; i++) {
            System.out.println((char) out.get(i));
        }
        System.out.println("Reading from memory mapped file is completed");

        //flush 到磁盘中
        out.force();

        randomAccessFile.close();

    }
}

package com.example.common.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author: lingjun.jlj
 * @date: 2019/12/29 16:22
 * @description: RandomAccessFile 访问文件的部分内容
 */
public class RandomAccessFileTest {

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/jianglingjun/Document/temp/test.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        // r以读的方式打开；rw 读写的方式打开；rws  rwd
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        System.out.println("文件指针位置：" + raf.getFilePointer());
        raf.writeInt(20);
        System.out.println("文件指针：" + raf.getFilePointer());
        raf.writeBoolean(true);
        raf.writeBoolean(false);
        raf.close();

        //读取文件
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        int out = randomAccessFile.readInt();
        System.out.println(out);
        System.out.println(randomAccessFile.readBoolean());
        System.out.println(randomAccessFile.readBoolean());
        randomAccessFile.close();

    }
}

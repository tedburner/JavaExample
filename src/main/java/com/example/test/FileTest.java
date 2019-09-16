package com.example.test;

import java.io.File;

/**
 * @author: lingjun.jlj
 * @date: 2019/9/16 14:46
 * @description:
 */
public class FileTest {

    public static void main(String[] args) {
        renameTo();
    }

    public static void renameTo() {
        try {
            File source = new File("D:\\Document\\txt\\test.txt");
            File target = new File("D:\\Document\\directSell\\test\\test.txt");
            source.renameTo(target);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

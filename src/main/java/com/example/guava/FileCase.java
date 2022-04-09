package com.example.guava;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.File;
import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2022/2/27 12:23
 * @description:
 */
public class FileCase {

    public static void main(String[] args) {
        File file = new File("D:\\Document\\temp\\test.txt");
        List<String> list = null;
        try {
            list = Files.readLines(file, Charsets.UTF_8);
        }catch (Exception e){
        }
        // 文件拷贝
//        Files.copy(form, to);
//        Files.move(File from, File to);
    }
}

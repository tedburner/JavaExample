package com.example.common.io.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author: lingjun.jlj
 * @date: 2019/6/18 10:43
 * @description: 文件IO操作
 */
public class FileTest {

    public static void main(String[] args) throws IOException {
//        File dir = new File("C:\\Document");
//        listAllFiles(dir);

        readFileContent("C:\\Document\\test.txt");
    }

    /**
     * 递归列出一个目录下所有文件
     *
     * @param dir
     */
    public static void listAllFiles(File dir) {
        if (dir == null || !dir.exists()) {
            return;
        }
        if (dir.isFile()) {
            System.out.println(dir.getName());
            return;
        }
        for (File file : dir.listFiles()) {
            listAllFiles(file);
        }
    }

    /**
     * 实现文件复制
     *
     * @param src
     * @param dist
     */
    public static void copyFile(String src, String dist) {
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream(src);
            out = new FileOutputStream(dist);

            byte[] buffer = new byte[20 * 1024];
            int cnt;
            // read() 最多读取 buffer.length 个字节
            // 返回的是实际读取的个数
            // 返回 -1 的时候表示读到 eof，即文件尾
            while ((cnt = in.read(buffer, 0, buffer.length)) != -1) {
                out.write(buffer, 0, cnt);
            }
        } catch (IOException e) {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }


        }
    }


    public static void readFileContent(String filePath) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        bufferedReader.close();
    }
}

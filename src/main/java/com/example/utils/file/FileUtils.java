package com.example.utils.file;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;

/**
 * @author: lingjun.jlj
 * @date: 2021/4/28 13:48
 * @description:
 */
public class FileUtils {

    public static void unzip(String sourcePath, String targetPath) {
        try {
            ZipFile zipFile = new ZipFile(sourcePath);
            zipFile.extractAll(targetPath);
        } catch (ZipException e) {
            e.printStackTrace();
        }
    }
}

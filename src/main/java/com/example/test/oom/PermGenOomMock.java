package com.example.test.oom;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Lucifer
 * @date: 2018/11/15 16:35
 * @description:
 */
public class PermGenOomMock {


    public static void main(String[] args) {
        URL url = null;
        List<ClassLoader> classLoaderList = new ArrayList<>();
        try {
            url = new File("/tmp").toURI().toURL();
            URL[] urls = {url};
            while (true) {
                ClassLoader loader = new URLClassLoader(urls);
                classLoaderList.add(loader);
                loader.loadClass("com.example.test.oom.OOMTest");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

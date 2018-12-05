package com.example.basejava.classloader;

import java.io.FileNotFoundException;

/**
 * @author: Lucifer
 * @date: 2018-12-04 22:23
 * @description: 自定义类加载器
 */
public class CustomClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] bytes = getClassFromCustomPath(name);
            if (null == bytes) {
                throw new FileNotFoundException();
            } else {
                return defineClass(name, bytes, 0, bytes.length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new ClassNotFoundException(name);
    }

    /**
     * 从指定路径中加载指定类
     */
    private byte[] getClassFromCustomPath(String name) {

        return new byte[1];
    }

    public static void main(String[] args) {
        CustomClassLoader customClassLoader = new CustomClassLoader();
        try {
            Class<?> clazz = Class.forName("One", true, customClassLoader);
            Object object = clazz.newInstance();
            System.out.println(object.getClass().getClassLoader());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

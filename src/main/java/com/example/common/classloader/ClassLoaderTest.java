package com.example.common.classloader;



/**
 * @author: Lucifer
 * @date: 2018-11-23 16:23
 * @description: java 类加载器
 */
public class ClassLoaderTest {

    public static void main(String[] args) {

        // Object 类在 <java_home>/jre/lib/rt.jar 中，
        // 由 Bootstrap ClassLoader 加载，由于该类加载器是由 native code 编写
        // 所以输出为 null
        Object[] objects = new Object[5];
        System.out.println(objects.getClass().getClassLoader());


        // ZipFileAttributes 类在 <java_home>/jre/lib/ext/zipfs.jar 中，
        // 由 Extension ClassLoader 加载，
        // 输出为  sun.misc.Launcher$ExtClassLoader@4b67cf4d
        //ZipFileAttributes[] attributes = new ZipFileAttributes[5];
        //System.out.println(attributes.getClass().getClassLoader());

        //ClassLoaderTest 类是自定义的类，
        // 默认由 System ClassLoader 加载，
        // 输出为 sun.misc.Launcher$AppClassLoader@18b4aac2
        ClassLoaderTest[] array = new ClassLoaderTest[5];
        array[0] = new ClassLoaderTest();
        System.out.println();
        System.out.println(array.getClass().getClassLoader());

    }
}

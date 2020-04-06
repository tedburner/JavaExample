package com.example.common.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author: lingjun.jlj
 * @date: 2019/5/9 14:27
 * @description: Java SPI，服务发现机制，遍历META-INF/services文件中的所有方法
 */
public class SpiDemo {

    public static void main(String[] args) {
        ServiceLoader<PrintService> services = ServiceLoader.load(PrintService.class);
        Iterator<PrintService> iterator = services.iterator();
        while (iterator.hasNext()) {
            iterator.next().sayHello();
        }
    }
}

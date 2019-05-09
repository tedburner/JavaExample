package com.example.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author: lingjun.jlj
 * @date: 2019/5/9 14:27
 * @description:
 */
public class SpiDemo {

    public static void main(String[] args) {
        ServiceLoader<Spi> services = ServiceLoader.load(Spi.class);
        Iterator<Spi> iterator = services.iterator();
        while (iterator.hasNext()) {
            iterator.next().sayHello();
        }
    }
}

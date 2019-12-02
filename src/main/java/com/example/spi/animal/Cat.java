package com.example.spi.animal;

import com.example.spi.Spi;

/**
 * @author: lingjun.jlj
 * @date: 2019/5/9 14:32
 * @description:
 */
public class Cat implements Spi {


    @Override
    public void sayHello() {
        System.out.println("Hello World! This is a Cat");
    }
}

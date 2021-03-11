package com.example.common.spi.animal;

import com.example.common.spi.PrintService;

/**
 * @author: lingjun.jlj
 * @date: 2019/5/9 14:32
 * @description:
 */
public class Cat implements PrintService {


    @Override
    public void sayHello() {
        System.out.println("Hello World! This is a Cat");
    }
}

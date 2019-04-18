package com.example.spring.aspectj;

/**
 * @author: lingjun.jlj
 * @date: 2019-04-08 22:13
 * @description:
 */
public class HelloWord {

    public void sayHello() {
        System.out.println("Hello AspectJ");
    }

    public static void main(String[] args) {
        HelloWord helloWord = new HelloWord();
        helloWord.sayHello();
    }
}

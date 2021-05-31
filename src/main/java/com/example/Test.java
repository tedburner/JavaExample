package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author: lingjun.jlj
 * @date: 2021/3/25 10:09
 * @description:
 */
public class Test {

    public static void main(String[] args) throws Exception {
        int status = 1;
        if (!(Objects.equals(status, 1) || Objects.equals(status, 2))) {
            System.out.println("111111");
            return;
        }
        System.out.println("22222");
    }
}

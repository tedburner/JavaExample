package com.example.test;

import java.math.BigDecimal;

/**
 * @author: Arthas
 * @date: 2019-07-13 16:21
 * @description:
 */
public class CompareToTest {

    public static void main(String[] args) {
        BigDecimal open = new BigDecimal(2);
        BigDecimal close = new BigDecimal(1);
        System.out.println(open.compareTo(close) > 0);
    }
}

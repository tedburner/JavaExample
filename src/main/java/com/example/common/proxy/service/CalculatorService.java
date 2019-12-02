package com.example.common.proxy.service;

import java.math.BigDecimal;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/11 14:19
 * @description:
 */
public interface CalculatorService {

    /**
     * 加法
     *
     * @param a
     * @param b
     */

    BigDecimal add(String a, String b);

    /**
     * 减法
     *
     * @param a
     * @param b
     */
    BigDecimal sub(String a, String b);

    /**
     * 乘法
     *
     * @param a
     * @param b
     */

    BigDecimal mul(String a, String b);

    /**
     * 除法
     *
     * @param a
     * @param b
     */
    BigDecimal div(String a, String b);

}

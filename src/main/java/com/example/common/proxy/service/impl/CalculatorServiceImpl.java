package com.example.common.proxy.service.impl;

import com.example.common.proxy.service.CalculatorService;

import java.math.BigDecimal;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/11 14:23
 * @description:
 */
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public BigDecimal add(String a, String b) {
        BigDecimal n1 = new BigDecimal(a);
        BigDecimal n2 = new BigDecimal(b);
        return n1.add(n2);
    }

    @Override
    public BigDecimal sub(String a, String b) {
        BigDecimal n1 = new BigDecimal(a);
        BigDecimal n2 = new BigDecimal(b);
        return n1.subtract(n2);
    }

    @Override
    public BigDecimal mul(String a, String b) {
        BigDecimal n1 = new BigDecimal(a);
        BigDecimal n2 = new BigDecimal(b);
        return n1.multiply(n2);
    }

    @Override
    public BigDecimal div(String a, String b) {
        BigDecimal n1 = new BigDecimal(a);
        BigDecimal n2 = new BigDecimal(b);
        return n1.divide(n2);
    }
}

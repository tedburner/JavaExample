package com.example.designpattern.strateg;

/**
 * @Auther: lingjun, hkh
 * @Date: 2018/7/4 23:22
 * @Description:
 */
public class OperationSubstract implements Strategy {

    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}

package com.example.common.proxy.service.impl;

import com.example.common.proxy.service.AopService;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/11 14:02
 * @description:
 */
public class AopServiceImpl implements AopService {

    @Override
    public void sayAop() {
        System.out.println("正在执行Service代码！");
    }
}

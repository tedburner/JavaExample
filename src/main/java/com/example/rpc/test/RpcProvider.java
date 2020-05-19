package com.example.rpc.test;

import com.example.rpc.framework.RpcFramework;

/**
 * @author: lingjun.jlj
 * @date: 2019-01-14 15:13
 * @description: 暴露服务
 */
public class RpcProvider {

    public static void main(String[] args) throws Exception {
        HelloService service = new HelloServiceImpl();
        RpcFramework.export(service, 1234);
    }
}

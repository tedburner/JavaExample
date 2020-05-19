package com.example.rpc.test;

import com.example.rpc.framework.RpcFramework;

/**
 * @author: lingjun.jlj
 * @date: 2019-01-14 15:14
 * @description: 引用服务
 */
public class RpcConsumer {

    public static void main(String[] args) throws Exception {
        HelloService service = RpcFramework.refer(HelloService.class, "127.0.0.1", 1234);
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String hello = service.hello("World" + i);
            System.out.println(hello);
            Thread.sleep(1000);
        }
    }
}

package com.example.etcd;

import com.example.etcd.client.JdEtcdClient;
import com.ibm.etcd.client.EtcdClient;

/**
 * @author: lingjun.jlj
 * @date: 2021/3/29 14:29
 * @description:
 */
public class EtcdClientTest {

    public static void main(String[] args) {
        JdEtcdClient etcdClient = build("127.0.0.1",2379);
        etcdClient.put("1","1");
        System.out.println(etcdClient.get("1"));
    }

    public static JdEtcdClient build(String endPoints, int port) {
        return new JdEtcdClient(EtcdClient.forEndpoint(endPoints, port)
                .withPlainText().build());
    }

}

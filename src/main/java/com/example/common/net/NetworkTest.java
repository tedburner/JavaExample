package com.example.common.net;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author: lingjun.jlj
 * @date: 2019/6/18 11:15
 * @description:
 */
public class NetworkTest {

    public static void main(String[] args) throws UnknownHostException, UnsupportedEncodingException {

        InetAddress address = InetAddress.getByName("www.baidu.com");

        System.out.println(new String(address.getAddress(), "UTF-8"));
    }
}

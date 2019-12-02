package com.example.test;

import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2019/7/17 09:34
 * @version：1.0.0
 * @description:
 */
public class HttpClientTest {

    public static void main(String[] args) {
        List<NameValuePair> list = new ArrayList<>();
        list.add(new BasicNameValuePair("accid", "12314141"));
        UrlEncodedFormEntity encodedFormEntity = new UrlEncodedFormEntity(list, Consts.UTF_8);
        System.out.println(encodedFormEntity);
    }
}

package com.example;

import com.example.common.java8.BeanData;
import com.example.domain.bean.SimpleDTO;

import java.util.Collections;
import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2021/3/25 10:09
 * @description:
 */
public class Test {

    public static void main(String[] args) throws Exception {
        List<SimpleDTO> list = BeanData.getBeanData();
        Collections.shuffle(list);
        list.forEach(System.out::println);
    }
}

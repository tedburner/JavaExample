package com.example.common.java8;

import com.example.domain.bean.SimpleDTO;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: lingjun.jlj
 * @date: 2020/4/13 10:49
 * @description:
 */
public class PeekDemo {

    public static void main(String[] args) {
        List<SimpleDTO> list = BeanData.getBeanDataList();
        System.out.println(list);

        List<SimpleDTO> peekList = list.stream()
                .peek(input -> input.setContent("今天星期一")).collect(Collectors.toList());

        System.out.println(peekList);
    }
}

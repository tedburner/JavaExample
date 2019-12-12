package com.example.common.java8.lambda;

import com.example.domain.bean.SimpleDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: lingjun.jlj
 * @date: 2019/6/28 13:55
 * @version：1.0
 * @description: 比较stream 和 parallelStream 效率
 */
public class StreamTest {

    public static void main(String[] args) {
        List<SimpleDTO> list = new ArrayList<>();
        for (int i = 1; i < 100000; i++) {
            SimpleDTO dto = new SimpleDTO();
            dto.setId(i);
            dto.setName("测试员" + i + "号");
            dto.setContent("Stream 测试普通和并行的效率");
            list.add(dto);
        }

        List<SimpleDTO> testList = list;

        Long stattTime = System.currentTimeMillis();
        List<String> list1 = list.stream()
                .filter(x -> x.getId() > 1000)
                .map(SimpleDTO::getName)
                .collect(Collectors.toList());
        Long endTime = System.currentTimeMillis();

        System.out.println("stream 耗时：" + (endTime - stattTime) + "ms");

        List<String> list2 = testList.parallelStream()
                .filter(x -> x.getId() > 1000)
                .map(SimpleDTO::getName)
                .collect(Collectors.toList());
        Long endTime1 = System.currentTimeMillis();

        System.out.println("parallelStream 耗时：" + (endTime1 - endTime) + "ms");
    }
}

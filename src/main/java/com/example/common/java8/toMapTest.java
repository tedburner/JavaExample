package com.example.common.java8;

import com.example.domain.bean.SimpleDTO;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author lingjun.jlj
 * @date 2017-12-28
 * @description: toMap 对于重复Key的处理
 */
public class toMapTest {

    public static void main(String[] args) {
        List<SimpleDTO> beans = BeanData.getBeanDataList();
        //当key出现重复的情况下，会出现 Duplicate key
        Map<Integer, String> beanMap = beans.stream()
                .collect(Collectors.toMap(SimpleDTO::getId, SimpleDTO::getName));
        System.out.println(beanMap);

        //解决key冲突问题，使用新的value替换原来的value
        Map<Integer, String> map = beans.stream()
                .collect(Collectors.toMap(SimpleDTO::getId, SimpleDTO::getName, (oldValue, newValue) -> newValue));
        System.out.println(map);
    }
}

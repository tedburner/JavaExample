package com.example.common.java8;


import com.alibaba.fastjson.JSON;
import com.example.domain.bean.SimpleDTO;
import com.example.domain.bean.UserDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author lingjun.jlj
 * @date 2017-12-27
 **/
public class groupingByTest {

    public static void main(String[] args) {

        List<String> items = Arrays.asList("Apple", "Apple", "orange",
                "Apple", "orange", "banana", "papaya");

        Map<String, Long> result = items
                .stream()
                .collect(Collectors
                        .groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(result);

        //排序
        Map<String, Long> finalMap = new LinkedHashMap<>();
        //sort a map and add to finalMap
        result.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue()
                        .reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

        System.out.println(finalMap);
        //数据统计
        List<SimpleDTO> beans = BeanData.getBeanDataList();
        Map<Integer, Long> countMap = beans
                .stream().collect(
                        Collectors.groupingBy(SimpleDTO::getId, Collectors.counting()));
        System.out.println(countMap);

        Map<Integer, List<SimpleDTO>> listMap = beans.stream().collect(
                Collectors.groupingBy(SimpleDTO::getId));
        System.out.println(JSON.toJSON(listMap));

        //Map 的value值自行聚合
        Map<Integer, Set<String>> setMap = beans.stream().collect(
                Collectors.groupingBy(SimpleDTO::getId, Collectors.mapping(SimpleDTO::getName, Collectors.toSet()))
        );
        System.out.println(JSON.toJSON(setMap));

        //Map的value重新聚合一个新的对象
        Map<Integer, List<UserDTO>> collectMap = beans.stream()
                .collect(Collectors.groupingBy(SimpleDTO::getId,
                        Collectors.collectingAndThen(Collectors.toList(), input -> input.stream()
                                .map(m -> {
                                    UserDTO user = new UserDTO();
                                    user.setId(m.getId());
                                    user.setUsername(m.getName());
                                    return user;
                                }).collect(Collectors.toList())
                        )));
        System.out.println(JSON.toJSON(collectMap));

        SimpleDTO dto1 = new SimpleDTO(1, "Jack", "1");
        SimpleDTO dto2 = new SimpleDTO(2, "James", "2");
        SimpleDTO dto3 = new SimpleDTO(3, "Hangzhou", "3");
        SimpleDTO dto4 = new SimpleDTO(3, "Hangzhou", "4");
        List<SimpleDTO> list = new ArrayList<>();
        list.add(dto1);
        list.add(dto2);
        list.add(dto3);
        list.add(dto4);

        //自行拼接KEY
        Map<String, List<SimpleDTO>> mapKey = list.stream()
                .collect(Collectors.groupingBy(e -> fetchGroupKey(e)));
        System.out.println(mapKey);

    }

    private static String fetchGroupKey(SimpleDTO dto) {
        return dto.getId() + "_" + dto.getName();
    }
}

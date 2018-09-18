package com.example.basejava.Java8;



import com.example.model.bean.SimpleDTO;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author lingjun.jlj
 * @date 2017-12-27
 **/
public class groupingByTest {

    public static void main(String[] args){

        List<String> items = Arrays.asList("Apple", "Apple", "orange",
                        "Apple", "orange", "banana", "papaya");

        Map<String,Long> result = items
                .stream()
                .collect(Collectors
                        .groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(result);

        //排序
        Map<String, Long> finalMap = new LinkedHashMap<>();
        //sort a map and add to finalMap
        result.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue()
                        .reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

        System.out.println(finalMap);
        //数据统计
        BeanData beanData = new BeanData();
        List<SimpleDTO> beans = beanData.getBeanDataList();
        Map<Integer,Long> countMap = beans
                .stream().collect(
                        Collectors.groupingBy(SimpleDTO::getId,Collectors.counting()));
        System.out.println(countMap);

        Map<Integer,List<SimpleDTO>> listMap = beans.stream().collect(
                Collectors.groupingBy(SimpleDTO::getId));
        System.out.println(listMap);

        Map<Integer,Set<String>> setMap = beans.stream().collect(
                Collectors.groupingBy(SimpleDTO::getId,Collectors.mapping(SimpleDTO::getName,Collectors.toSet()))
        );

        System.out.println(setMap);


    }
}

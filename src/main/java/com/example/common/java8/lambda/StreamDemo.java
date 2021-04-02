package com.example.common.java8.lambda;


import com.alibaba.fastjson.JSON;
import com.example.common.java8.BeanData;
import com.example.domain.bean.SimpleDTO;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author lingjun.jlj
 * @date 2017-12-27
 **/
public class StreamDemo {

    public static void main(String[] args) {
        String str = "1,2,3,4,10,11,9,66,222,12";
        //倒序
        List<Integer> list = Stream.of(str.split(","))
                .map(Integer::valueOf)
                .filter(x -> !Objects.equals(x, 3))
                .sorted(Comparator.reverseOrder())
                .limit(4)
                .collect(Collectors.toList());
        System.out.println(list);


        //对象的正序排列后，又倒序了
        List<SimpleDTO> beans = BeanData.getDataList();
        System.out.println("排序前：" + JSON.toJSONString(beans));
        List<SimpleDTO> list1 = beans
                .stream()
                .sorted(Comparator.comparing(SimpleDTO::getId).reversed()
                        .thenComparing(SimpleDTO::getName))
                .collect(Collectors.toList());
        System.out.println("排序后：" + JSON.toJSONString(list1));

        System.out.println("====================== Stream count ==================================");
        long count = list.stream().count();
        System.out.println("统计计数： " + count);

        System.out.println("============ Stream map ==============");
        List<Integer> idList = beans.stream()
                .map(SimpleDTO::getId)
                .collect(Collectors.toList());

        System.out.println("============ Stream filter ==============");
        String[][] data = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};
        Stream<String[]> temp = Arrays.stream(data);
        Stream<String[]> tempStream = temp.filter(x -> "a".equals(x.toString()));

        List<Integer> values = Stream.of(str.split(","))
                .parallel() //使用并行流
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        System.out.println("====================== reduce ==================================");
        Optional<Integer> sum = values.stream()
                .reduce((x, y) -> x + y);
        if (sum.isPresent()) {
            System.out.println("reduce 计算结果： " + sum.get());
        }

        System.out.println("====================== flatMap 合并List ==================================");
        List<Integer> a = Arrays.asList(1, 2);
        List<Integer> b = Arrays.asList(3, 4);

        List<Integer> together = Stream.of(a, b)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        together.forEach(System.out::println);

        System.out.println("====================== 字符串 ==================================");
        List<String> languages = Arrays.asList("Scala", "Python", "Java", "Go", "C", "C++");
        String result = languages.stream()
                .collect(Collectors.joining(",", "[", "]"));
        System.out.println("字符串拼接后结果：" + result);

        System.out.println("====================== Stream allMatch ==================================");
        List<Integer> array = Arrays.asList(1, 1, 1, 1, 2);
        boolean allMatch = array.stream()
                .allMatch(input -> Objects.equals(input, 1));
        System.out.println("集合中所有数据是否都等于1：" + allMatch);

        System.out.println("====================== Stream anyMatch ==================================");
        boolean anyMatch = BeanData.getDataList().stream()
                .anyMatch(input -> Objects.equals(input.getId(), 1));
        System.out.println("集合中是否含有id为1的数据：" + anyMatch);

        System.out.println("====================== Stream noneMatch ==================================");
        boolean noneMatch = BeanData.getDataList().stream()
                .noneMatch(input -> Objects.equals(input.getId(), 4));
        System.out.println("集合中是否数据id都不为4：" + noneMatch);
    }
}

package com.example.common.Java8.Lambda;


import com.example.common.Java8.BeanData;
import com.example.domain.bean.SimpleDTO;

import java.util.Arrays;
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
public class StreamTest {

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
        BeanData beanData = new BeanData();
        List<SimpleDTO> beans = beanData.getBeanDataList();
        List<SimpleDTO> list1 = beans
                .stream()
                .sorted(Comparator.comparing(SimpleDTO::getId).reversed()
                        .thenComparing(x -> x.getName()))
                .collect(Collectors.toList());
        System.out.println(list1);

        Long count = list.stream().count();
        System.out.println("统计计数： " + count);

        System.out.println("============聚合ID==============");
        List<Integer> idList = beans.stream()
                .map(SimpleDTO::getId)
                .collect(Collectors.toList());

        String[][] data = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};
        Stream<String[]> temp = Arrays.stream(data);
        Stream<String[]> tempStream = temp.filter(x -> "a".equals(x.toString()));

        List<Integer> values = Stream.of(str.split(","))
                .parallel() //使用并行流
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        Optional<Integer> sum = values.stream()
                .reduce((x, y) -> x + y);
        if (sum.isPresent()) {
            System.out.println("reduce 计算结果： " + sum.get());
        }
    }
}

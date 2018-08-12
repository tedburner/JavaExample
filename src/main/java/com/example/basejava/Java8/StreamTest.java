package com.example.basejava.Java8;


import com.example.basejava.Java8.bean.SimpleDTO;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author lingjun.jlj
 * @date 2017-12-27
 **/
public class StreamTest {

    public static void main(String [] args){
        String str = "1,2,3,4,10,11,9,66,222,12";
        //倒序
        List<Integer> list = Stream.of(str.split(","))
                .map(Integer::valueOf)
                .filter(x-> !Objects.equals(x,3))
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
                .thenComparing(x->x.getName()))
                .collect(Collectors.toList());
        System.out.println(list1);

        Long count = list.stream().count();
        List<Integer> idList = beans.stream().map(SimpleDTO::getId).collect(Collectors.toList());

        String[][] data = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};
        Stream<String[]> temp = Arrays.stream(data);
        Stream<String[]> stream = temp.filter(x -> "a".equals(x.toString()));
    }
}

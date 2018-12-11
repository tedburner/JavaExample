package com.example.basejava.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/10 15:10
 * @description: 测试ArrayList循环删除
 */
public class ArrayListTest {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("aa", "aa", "bb", "bb", "cc", "cc", "dd", "dd");

        for (int i = 0; i < list.size(); i++) {
            if ("aa".equals(list.get(i))) {
                list.remove(i);
            }
        }
        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.size());
            if ("bb".equals(list.get(i))) {
                list.remove("bb");
            }
        }
        System.out.println(list);

        for (String obj : list) {
            if (obj.equals("cc")) {
                list.remove(obj);
            }
        }

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String s = it.next();
            if (s.equals("dd")) {
                it.remove();
            }
        }
        System.out.println(list);
    }

}

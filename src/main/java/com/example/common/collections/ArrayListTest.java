package com.example.common.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/10 15:10
 * @description: 测试ArrayList循环删除
 * 循环县标以及foreach 删除都会出现问题，只有使用迭代器进行循环删除才可以。
 */
public class ArrayListTest {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("aa", "aa", "bb", "bb", "cc", "cc", "dd", "dd");

        //方法一：普通for循环正序删除，删除过程中元素向左移动，不能删除重复的元素
        for (int i = 0; i < list.size(); i++) {
            if ("aa".equals(list.get(i))) {
                list.remove(i);
            }
        }
        System.out.println(list);

        // 方法二：普通for循环倒序删除，删除过程中元素向左移动，可以删除重复的元素
        for (int i = list.size(); i < list.size(); i--) {
            System.out.println(list.size());
            if ("bb".equals(list.get(i))) {
                list.remove("bb");
            }
        }
        System.out.println(list);

        //方法三：增强for循环删除，使用ArrayList的remove()方法删除，产生并发修改异常 ConcurrentModificationException
        for (String obj : list) {
            if (obj.equals("cc")) {
                list.remove(obj);
            }
        }

        // 方法四：迭代器，使用ArrayList的remove()方法删除，产生并发修改异常 ConcurrentModificationException
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals("aa")) {
                list.remove(iterator.next());
            }
        }

        // 方法五：迭代器，使用迭代器的remove()方法删除，可以删除重复的元素，但不推荐
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

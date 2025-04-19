package com.example.guava.collection;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicates;
import com.google.common.base.Splitter;
import com.google.common.collect.*;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author: lingjun.jlj
 * @date: 2022/2/27 11:40
 * @description: Google Guava List 基础操作
 */
public class ListCase {

    public static void main(String[] args) {
        List<String> list = Lists.newArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        String join = Joiner.on(";").join(list);
        // 输出结果：a;b;c
        System.out.println(join);
        // 字符串切割:[a, b, c]
        List<String> spilt = Splitter.on(";").splitToList(join);
        System.out.println(spilt);

        //反转list
        List<String> reverseList1 = Lists.reverse(spilt);
        System.out.println("反转：" + reverseList1);

        // 集合过滤 [guava, Java]
        ImmutableList<String> names = ImmutableList.of("code", "guava", "google", "alibaba", "Java", "Go");
        Iterable<String> filterList = Iterables.filter(names, Predicates.or(
                Predicates.equalTo("guava"), Predicates.equalTo("Java")));
        System.out.println(filterList);

        // 自定义过滤条件: {a=12, b=15}
        ImmutableMap<String, Integer> m = ImmutableMap.of("a", 12, "b", 15);
        // Function<F, T> 中 F表示apply()方法input的类型，T表示apply()返回的类型
        Map<String, Integer> m2 = Maps.transformValues(m, new Function<Integer, Integer>() {
            @Override
            public @Nullable Integer apply(@Nullable Integer input) {
                if (input > 12) {
                    return input;
                } else {
                    return input++;
                }
            }
        });
        System.out.println(m);

        // 交集、并集、差集
        Set<String> set1 = Sets.newHashSet("a", "b", "c");
        Set<String> set2 = Sets.newHashSet("a", "c", "d");
        // 并集
        Sets.SetView<String> union = Sets.union(set1, set2);
        System.out.println("并集:" + union);
        // 差集
        Sets.SetView<String> difference = Sets.difference(set1, set2);
        System.out.println("差集" + difference);
        // 交集
        Sets.SetView<String> intersection = Sets.intersection(set1, set2);
        System.out.println("交集:" + intersection);
    }
}

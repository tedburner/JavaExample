package com.example.guava.collection;

import cn.hutool.crypto.digest.DigestUtil;
import com.google.common.collect.Sets;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lingjun.jlj
 * @date 2022/7/30 15:03
 */
public class SetCase {

    public static void main(String[] args) {
        int num = 200;
        String query = "FUCK YOU 阿曼达家的骄傲到哪里看淡开单卡卡的卡拉多金坷垃肯德基卡了";
        Set<String> set1 = new HashSet<>(num);
        Set<String> set2 = new HashSet<>(num);
        for (int i = 0; i < num; i++) {
            String newQuery = query + i;
            String md5Key = DigestUtil.md5Hex16(newQuery);
            set1.add(md5Key);
            if (i < 120) {
                set2.add(md5Key);
            }
        }
        System.out.println("===========开始计算交集=======");
        long time1 = System.currentTimeMillis();
        Set<String> intersection = Sets.intersection(set1, set2);
        long time2 = System.currentTimeMillis();
        System.out.println("计算交集：" + intersection.size());
        System.out.println("计算交集耗时：" + (time2 - time1) + "ms");
        System.out.println("===========开始计算合集=======");
        Set<String> unionSet = Sets.union(set1, set2);
        long time3 = System.currentTimeMillis();
        System.out.println("计算合集：" + unionSet.size());
        System.out.println("计算合集耗时：" + (time3 - time2) + "ms");
        System.out.println("===========开始计算差集=======");
        // set1 中有而 set2 中没有的
        Set<String> differenceSet = Sets.difference(set1, set2);
        System.out.println("计算差集：" + differenceSet.size());
        // 相对差集，set1中有set2中没有；set2中有，set1中没有，去除做结果
        Set<String> sdSet = Sets.symmetricDifference(set1, set2);
        System.out.println("计算相对差集：" + sdSet.size());
    }
}

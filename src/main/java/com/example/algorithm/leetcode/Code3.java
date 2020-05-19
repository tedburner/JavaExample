package com.example.algorithm.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2019-03-16 20:17
 * @description: 无重复字符的最长子串
 */
public class Code3 {

    public static void main(String[] args) {
        String string = "nfpdmpi";
        System.out.println(lengthOfLongestSubstring(string));

    }

    public static int lengthOfLongestSubstring(String s) {
        List<String> list = new LinkedList<>();
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            //如果集合中不存在这个字符，则加入集合
            if (!list.contains(String.valueOf(ch))) {
                list.add(String.valueOf(ch));
                if (length < list.size()) {
                    length = list.size();
                }
            } else {
                int k = 0;
                //判断当前元素和集中和哪个位置的元素重复
                for (int j = list.size() - 1; j >= 0; j--) {
                    if (list.get(j).equals(String.valueOf(ch))) {
                        k = j;
                    }
                }
                //删除之前计算出重复位置之前的所有元素
                for (int n = k; n >=0; n--) {
                    list.remove(n);
                }
                //删除集合中和当前元素相同的元素
                list.remove(String.valueOf(ch));
                //把当前元素添加集合
                list.add(String.valueOf(ch));
                //判断当前的集合长度是否大于记录的集合大小
                if (length < list.size()) {
                    length = list.size();
                }
            }
        }
        return length;
    }
}

package com.example.algorithm.LeetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: Arthas
 * @date: 2019-03-16 20:17
 * @description: Longest Substring Without Repeating Characters
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
            if (!list.contains(String.valueOf(ch))) {
                list.add(String.valueOf(ch));
                if (length < list.size()) {
                    length = list.size();
                }
            } else {
                int k = 0;
                for (int j = list.size() - 1; j >= 0; j--) {
                    if (list.get(j).equals(String.valueOf(ch))) {
                        k = j;
                    }
                }
                for (int n = k; n >=0; n--) {
                    list.remove(n);
                }
                list.remove(String.valueOf(ch));
                list.add(String.valueOf(ch));
                if (length < list.size()) {
                    length = list.size();
                }
            }
        }
        return length;
    }
}

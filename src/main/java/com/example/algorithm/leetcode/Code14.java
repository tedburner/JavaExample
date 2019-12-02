package com.example.algorithm.leetcode;

import java.util.Objects;

/**
 * @author: Arthas
 * @date: 2019-07-27 22:48
 * @description: 最长公共前缀
 */
public class Code14 {

    public static void main(String[] args) {
        //String[] strs = new String[]{"flower", "flow", "flight"};
        String[] strs = new String[]{"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        //获取字符串的最短长度
        int length = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            if (length > strs[i].length()) {
                length = strs[i].length();
            }
        }
        //比较相同字符串
        String sameStr = "";
        boolean flag = true;
        for (int i = 0; i < length; i++) {
            char same = strs[0].charAt(i);
            for (int k = 1; k < strs.length; k++) {
                if (!Objects.equals(same, strs[k].charAt(i))) {
                    flag = false;
                    break;
                }
            }
            //如果存在不相等，则返回
            if (!flag) {
                return sameStr;
            } else {
                sameStr = sameStr + same;
            }
        }
        return sameStr;
    }
}

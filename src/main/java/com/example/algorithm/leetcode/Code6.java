package com.example.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2019/8/13 14:35
 * @description: Z 字形变换
 */
public class Code6 {

    public static void main(String[] args) {
        System.out.println(convert("AB", 1));
    }

/*
    0       4       8
    1   3   5   7   9
    2       6       10

    0           6           12
    1       5   7       11  13
    2   4       8   10      14
    3           9           15
 */

    /**
     * 字形变换，通过设置flag标志位，来表示Z字形的跳转位置
     *
     * @param s       指定字符串
     * @param numRows Z字形行数
     * @return
     */
    public static String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) list.add(new StringBuilder());
        int flag = -1;
        int index = 0;
        for (int k = 0; k < s.length(); k++) {
            char ch = s.charAt(k);
            list.get(index).append(ch);
            //判断Z字形跳转处
            if (index == 0 || index == (numRows - 1)) {
                flag = -flag;
            }
            index += flag;
        }
        StringBuilder ans = new StringBuilder();
        for (StringBuilder builder : list) {
            ans.append(builder);
        }
        return ans.toString();
    }

}

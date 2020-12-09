package com.example.algorithm.mianshi;

/**
 * @author: lingjun.jlj
 * @date: 2020/12/9 10:53
 * @description: 字母消消乐
 */
public class CharReplace {

    public static void main(String[] args) {
        //System.out.println("字母消消乐结果：" + eliminateStr("aA"));
        System.out.println("字母消消乐结果：" + eliminateStr("abBA"));
    }

    public static String eliminateStr(String str) {
        if (str.length() <= 1) {
            return str;
        }
        boolean flag = false;
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < str.length(); i++) {
            //标记当前字符的位置
            int m = i;
            char last = str.charAt(i - 1);
            char now = str.charAt(i);
            int num = Math.abs(now - last);
            if (num != ('a' - 'A')) {
                builder.append(last);
                if (i == (str.length() - 1)) {
                    builder.append(now);
                }
            } else {
                flag = true;
            }
        }
        if (!flag) {
            return str;
        }
        return eliminateStr(builder.toString());
    }
}

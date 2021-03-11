package com.example.algorithm.mianshi.zhaoshang;

import java.util.Scanner;

/**
 * @author: lingjun.jlj
 * @date: 2021/1/10 10:46
 * @description: 招商银行笔试1
 */
public class Code1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        if (str.length() == 0) {
            System.out.println(str);
            return;
        }
        StringBuilder specialChar = new StringBuilder();
        StringBuilder enChar = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '*') {
                specialChar.append(ch);
            } else {
                enChar.append(ch);
            }
        }
        String result = specialChar.toString()+enChar.toString();

        System.out.println(result);

    }
}

package com.example.algorithm.leetcode.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: lingjun.jlj
 * @date: 2019/9/10 17:19
 * @description: 电话号码的字母组合
 */
public class Code17 {

    public static void main(String[] args) {

        System.out.println("23".substring(1));
        Code17 letter = new Code17();
        System.out.println(letter.letterCombinations("23"));
    }

    List<String> output = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        Map<String, String> phone = new HashMap<>(8);
        phone.put("2", "abc");
        phone.put("3", "def");
        phone.put("4", "ghi");
        phone.put("5", "jkl");
        phone.put("6", "mno");
        phone.put("7", "pqrs");
        phone.put("8", "tuv");
        phone.put("9", "wxyz");
        if (digits.length() != 0) {
            backtrack("", digits, phone);
        }
        return output;

    }

    public void backtrack(String combination, String nextDigits, Map<String, String> phone) {
        if (nextDigits.length() == 0) {
            output.add(combination);
        } else {
            String digit = nextDigits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = letters.substring(i, i + 1);
                backtrack(combination + letter, nextDigits.substring(1), phone);
            }
        }

    }

}

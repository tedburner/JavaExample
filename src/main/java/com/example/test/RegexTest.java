package com.example.test;

/**
 * @author: lingjun.jlj
 * @date: 2019/4/12 18:36
 * @description:
 */
public class RegexTest {

    public static void main(String[] args) {
        String pattern = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$";
        String pw1 = "123456";
        String pw2 = "abcdcq";
        String pw3 = "abc1234";


//        System.out.println(pw1.matches(pattern));
//        System.out.println(pw2.matches(pattern));
//        System.out.println(pw3.matches(pattern));

        String phonePattern = "^[1][3,4,5,7,8][0-9]{9}$";
        System.out.println("15372420890".matches(phonePattern));

    }
}

package com.example.guava;

import com.google.common.base.CaseFormat;
import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;

import java.util.List;
import java.util.Map;

/**
 * @author: lingjun.jlj
 * @date: 2022/2/27 12:29
 * @description:
 */
public class StringCase {

    public static void main(String[] args) {
        // 去除空格: [1, 2, 3, 4, 5, 6]
        String str = "1-2-3-4-  5-   6     ";
        List<String> trimList = Splitter.on("-")
                .omitEmptyStrings()
                // 可指定字符
                .trimResults()
                .splitToList(str);
        System.out.println(trimList);

        // String -> Map
        String mapStr = "zhangsan=25,lisi=90";
        Map<String, String> splitMap = Splitter.on(",")
                .withKeyValueSeparator("=")
                .split(mapStr);
        System.out.println(splitMap);

        // guava 支持多字符或者正则切分:[aa, dd, ff]
        String input = "aa.dd,,ff,,.";
        List<String> result = Splitter.onPattern("[.|,]")
                .omitEmptyStrings()
                .splitToList(input);
        System.out.println(result);

        System.out.println("==========CharMatcher===============");
        // 匹配所有的
        CharMatcher charMatcher1 = CharMatcher.any();
        CharMatcher charMatcher2 = CharMatcher.anyOf("aef");
        // 什么也不匹配的
        CharMatcher charMatcher3 = CharMatcher.none();
        // 匹配空白字符的
        CharMatcher charMatcher4 = CharMatcher.whitespace();
        CharMatcher charMatcher4_1 = CharMatcher.breakingWhitespace();
        // 匹配单个字符
        CharMatcher charMatcher5 = CharMatcher.is('a');
        CharMatcher charMatcher6 = CharMatcher.isNot('a');
        // 匹配范围
        CharMatcher charMatcher7 = CharMatcher.inRange('0', '9');
        CharMatcher charMatcher8 = CharMatcher.inRange('a', 'z');
        CharMatcher charMatcher9 = CharMatcher.inRange('A', 'Z');

        System.out.println("==========CaseFormat===============");
        // 转驼峰：constantName
        String lowerCamel = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "CONSTANT_NAME");
        System.out.println(lowerCamel);
        // 转驼峰：ConstantName
        String upperCamel = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, "CONSTANT_NAME");
        System.out.println(upperCamel);
        // 转小写：constant-name
        String lowerHyphen = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_HYPHEN, "CONSTANT_NAME");
        System.out.println(lowerHyphen);
        // 转小写：constant_name
        String lowerUnderscore = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_UNDERSCORE, "CONSTANT_NAME");
        System.out.println(lowerUnderscore);
        // CONSTANT_NAME
        String upperUnderscore = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_UNDERSCORE, "CONSTANT_NAME");
        System.out.println(upperUnderscore);
    }
}

package com.example.test;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2019/10/31 10:04
 * @description: 判断文本相似度
 */
public class NLPTextDemo {

    public static void main(String[] args) {
        List<String> textList = new ArrayList<>();
        textList.add("您好欢迎您在中国工商银行深圳分行高新园智航办理小汽车增量指标分期业务");
        textList.add("是");
        textList.add("感谢您的配合谢谢");
        String text = "您好欢迎您在中国工商银行深圳分行高新园智航办理小汽车增量指标";
        int dis = StringUtils.getLevenshteinDistance(textList.get(0), text);
        System.out.println(dis);
    }

}

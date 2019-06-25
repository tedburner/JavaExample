package com.example.test;

import com.alibaba.fastjson.JSON;
import com.example.domain.bean.SimpleDTO;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author: lingjun.jlj
 * @date: 2018/9/15 21:25
 * @description:
 */
public class Test {

    public static void fillPdfFields(Map<String, Object> params, String type, String field) {
        if (StringUtils.isBlank(field)) {
            params.put(type + "0", "");
            return;
        }
        for (int i = 0; i < field.length(); i++) {
            params.put(type + i, field.charAt(i));
        }
    }

    public static void main(String[] args) {

        String text = "请问您是[姓名]本人吗？";
        String[] fieldArray = StringUtils.substringsBetween(text, "[", "]");
        System.out.println(fieldArray.toString());
        for (String field : fieldArray) {
            text = StringUtils.replace(text, "[" + field + "]", "蒋灵俊");
        }

        System.out.println(text);

//        SimpleDTO dto = new SimpleDTO();
//        dto.setId(1);
//        dto.setContent("你好");
//        dto.setName("麻辉文");
//        String json = JSON.toJSONString(dto);
//        System.out.println(json);

//        //Arrays.asList体现的是适配器模式，只是转换接口，后台的数据仍是数组。
//        String[] str = new String[]{"alibaba", "腾讯"};
//        List list = Arrays.asList(str);
//        str[0] = "网易";
////        list.remove("腾讯");
//
//        System.out.println(list);
//        String time = "1560756159573";
//        Date date = new Date(Long.valueOf(time));
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(sdf.format(date));

//        Map<String, Object> params = new HashMap<>();
//        fillPdfFields(params, "income", null);
//        System.out.println(params);

//        Map<String, String> map = new HashMap<>();
//        System.out.println(map == null);
//        System.out.println(map.isEmpty());
//
//        String fileName = "/" + System.currentTimeMillis() + ".png";
//        String imagePath = new DateTime().toString("/YYYY/MM/dd");
//        String path = "C:\\Document\\card" + imagePath;
//        new File(path).mkdirs();

//        Integer a = null;
//        System.out.println(String.valueOf(a));
//        System.out.println(a.toString());
//
//        int index = StringUtils.lastIndexOf("1313.MP4", ".");
//        String suffix = StringUtils.substring("1313.MP4", index);
//        System.out.println(suffix);

//
//        String str = "邓丽梅|360732199310062621";
//        String[] identity = str.split("\\|");
//        System.out.println(identity[0] + " " + identity[1]);
//
//
//        String time = "199509082330";
//        System.out.println(time.substring(0, 4));
//        System.out.println(time.substring(4, 6));
//        System.out.println(time.substring(6, 8));
//
//        System.out.println(String.format("%02d", Integer.valueOf("07")));
//        Object[] elementData  =new Object[10];
//        int elementCount = 2;
//        int index = 1;
//        Object obj = "vector";
//        Object obj1 = "vector1";
//
//        elementData[0] = obj;
//        elementData[1] = obj;
//        elementData[2] = obj1;
//        elementData[3] = obj;
//        System.arraycopy(elementData, index, elementData, index + 1, elementCount - index);
//        System.out.print(elementData.toString());

//        System.out.println(System.currentTimeMillis());


//        int n = 9 - 1;
//        n |= n >>> 1;
//        n |= n >>> 2;
//        n |= n >>> 4;
//        n |= n >>> 8;
//        n |= n >>> 16;
//
//        System.out.println(n);
//
//        String a = "123";
//        String b = "123";
//        System.out.println(a == b);


//        String a = new String("100");
//        String b = new String("100");
//        Integer c = new Integer(100);
//        Long d = new Long(100);
//        System.out.println(a.equals(b));
//        System.out.println(a.equals(c));
//        System.out.println(a.equals(d));
//
//
//        char[] charArray = {'a', 'b', 'c'};
//        char[] charArray1 = charArray;
//        charArray1[1] = 'x';
//        System.out.println(charArray);

//        double source = 0.52;
//        double d1 = Math.round(source * 100) / 100;
//
//        double d2 = source * 100;
//        double d3 = Math.round(d2);
//        double d4 = d3 / 100;
//
//        System.out.println(d1);
//        System.out.println(d4);
//
//
//        System.out.println(52 / 100);
//
//
//        int i = 1;
//        int j = 1;
//        System.out.println(i++ + j);
//
//
//        Double duration = 472.0;
//        System.out.println(String.format("%.2f", duration / 60));

    }
}

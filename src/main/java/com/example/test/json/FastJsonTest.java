package com.example.test.json;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;

/**
 * @author lingjun.jlj
 * @date 2022/6/30 23:27
 */
public class FastJsonTest {

    public static void main(String[] args) {
        JSONObject data = new JSONObject();
        data.put("a", "a");
        data.put("b", "b");
        JSONObject after = new JSONObject(data);
//        after.put("c", "c");
        System.out.println("原始数据：" + data);
        System.out.println("修改后：" + after);

        System.out.println("========================");
        JSONObject obj = JSON.parseObject(data.toJSONString());
        obj.put("c", "c");
        System.out.println("原始数据：" + data);
        System.out.println("修改后：" + obj);

    }
}

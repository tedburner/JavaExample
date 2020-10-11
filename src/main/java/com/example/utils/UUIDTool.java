package com.example.utils;

import java.util.UUID;

/**
 * @author lingjun.jlj
 * @date: 2018/4/14
 */
public class UUIDTool {

    /**
     * 获取格式化后的UUID
     */
    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-", "");
    }


    public static void main(String[] args) {

    }
}

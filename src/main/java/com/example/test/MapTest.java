package com.example.test;

import com.example.domain.bean.SimpleDTO;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Arthas
 * @date: 2019-07-14 16:02
 * @description:
 */
public class MapTest {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>(2);
//        map.put("test", 1);
//        map.put("test1", "test");
//        System.out.println(map.get("test"));
//        System.out.println(map.get("test1"));
//
//        Map<String, SimpleDTO> simpleMap = new HashMap<>();
//        SimpleDTO dto1 = new SimpleDTO(1, "131", "1111");
//        simpleMap.put("1", dto1);
//        Map<String, String> strMap = new HashMap<>();
        Integer total =0;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            //strMap.put(entry.getKey(), entry.getValue().getName());
            total++;
        }

        System.out.println(total);


    }
}

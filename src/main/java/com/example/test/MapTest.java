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
        Map<String, SimpleDTO> map = new HashMap<>();
        SimpleDTO dto1 = new SimpleDTO(1,"131","1111");
        map.put("1",dto1);
        Map<String, String> strMap =new HashMap<>();
        for (Map.Entry<String, SimpleDTO> entry: map.entrySet()){
            strMap.put(entry.getKey(), entry.getValue().getName());
        }

        System.out.println(strMap);
    }
}

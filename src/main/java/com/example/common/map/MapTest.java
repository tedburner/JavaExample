package com.example.common.map;

import com.example.domain.bean.SimpleDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * Created by jlj on 2017/9/5.
 */
public class MapTest {

    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "孙博");
        List<SimpleDTO> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            SimpleDTO dto = new SimpleDTO();
            map.put(i, "孙" + i);
            dto.setId(i);
            dto.setName("name" + i);
            list.add(dto);

        }
        //两种map遍历
        for (Integer key : map.keySet()) {
            String value = map.get(key);
            System.out.println(value);
        }

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            String str = entry.getKey() + " " + entry.getValue();
            System.out.println(str);
        }
        //Java8使用流操作生成map
        Map<Integer, String> listMaps = list
                .stream()
                .collect(Collectors.toMap(x -> x.getId(), x -> x.getName()));
        for (Map.Entry<Integer, String> entry : listMaps.entrySet()) {
            String str = entry.getKey() + " " + entry.getValue();
            System.out.println(str);
        }
        Map<Integer, SimpleDTO> Maps = list
                .stream()
                .collect(Collectors.toMap(x -> x.getId(), x -> x));
        for (Map.Entry<Integer, SimpleDTO> entry : Maps.entrySet()) {
            String str = entry.getKey() + " " + entry.getValue().toString();
            System.out.println(str);
        }
        Map<Long, Object> curMap = new ConcurrentHashMap<>();
    }
}

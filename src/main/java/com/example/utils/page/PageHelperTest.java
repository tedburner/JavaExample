package com.example.utils.page;

import com.example.domain.bean.SimpleDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2019/12/24 15:06
 * @description:
 */
public class PageHelperTest {


    public static void main(String[] args) {
        int num = 20;
        List<SimpleDTO> list = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            SimpleDTO dto = new SimpleDTO();
            dto.setId(i);
            dto.setName("分页用户" + i);
            dto.setContent("测试分页数据");
            list.add(dto);
        }
        PageHelper<SimpleDTO> page = new PageHelper<>();
        Page<SimpleDTO> result = page.startPage(list, 4, 6);
        System.out.println(result);

    }
}

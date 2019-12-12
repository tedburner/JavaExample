package com.example.common.java8;

import com.example.domain.bean.SimpleDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lingjun.jlj
 * @date 2017-12-28
 **/
public class BeanData {

    public static List<SimpleDTO> getBeanData() {
        List<SimpleDTO> listDTOS = new ArrayList<>();
        for (int i=0;i<20;i++){
            SimpleDTO dto = new SimpleDTO();
            dto.setId(i);
            dto.setName("孙博"+i);
            listDTOS.add(dto);
        }
        return listDTOS;
    }

    public static List<SimpleDTO> getBeanDataList() {
        List<SimpleDTO> listDTOS = Arrays.asList(
                new SimpleDTO(1, "孙博"), new SimpleDTO(1, "二代"), new SimpleDTO(1, "孙博"),
                new SimpleDTO(2, "戴硕"), new SimpleDTO(2, "戴硕"), new SimpleDTO(2, "赛克"),
                new SimpleDTO(3, "二代"), new SimpleDTO(3, "路痴"), new SimpleDTO(3, "路痴"),
                new SimpleDTO(4, "赛克"), new SimpleDTO(4, "二代"), new SimpleDTO(4, "路痴")
        );

        return listDTOS;
    }
}


package com.example.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2020/1/9 16:16
 * @description:
 */
public class CompareTest {

    public static void main(String[] args) throws InterruptedException {
        List<CompareDTO> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            CompareDTO dto= new CompareDTO();
            Thread.sleep(100);
            dto.setId(System.currentTimeMillis());
            dto.setName("test"+i);
            list.add(dto);
        }
        list.sort((CompareDTO o1, CompareDTO o2) -> o2.getId().compareTo(o1.getId()));
        System.out.println(list);
    }
}

class CompareDTO {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CompareDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
package com.example.utils.page;

import lombok.Data;

import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2019/12/24 15:05
 * @description:
 */
@Data
public class Page<T> {

    private String total;

    private List<T> rows;
}

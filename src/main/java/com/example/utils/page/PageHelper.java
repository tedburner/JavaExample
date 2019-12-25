package com.example.utils.page;

import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2019/12/24 15:04
 * @description: 内存分页工具
 */
public class PageHelper<T> {

    public PageHelper() {
    }

    /**
     * 数组分页
     *
     * @param list 需要分页的数组
     * @param page 起始页，从1开始
     * @param size 每页大小
     */
    public Page<T> startPage(List<T> list, int page, int size) {
        int total = list.size();
        if (page < 1) {
            throw new RuntimeException("分页起始页必须从1开始");
        }
        int start = (page - 1) * size;
        int end = start + size;
        if (end > total) {
            end = total;
        }
        System.out.println("数组分页从" + start + "开始，到" + end);
        List<T> rows = list.subList(start, end);

        Page<T> result = new Page<>();
        result.setTotal(String.valueOf(total));
        result.setRows(rows);
        return result;
    }
}

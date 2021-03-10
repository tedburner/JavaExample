package com.example.utils.page;

import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2019/12/24 15:05
 * @description:
 */
public class Page<T> {

    private String total;

    private List<T> rows;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "Page{" +
                "total='" + total + '\'' +
                ", rows=" + rows +
                '}';
    }
}

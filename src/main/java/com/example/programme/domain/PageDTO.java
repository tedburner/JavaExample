package com.example.programme.domain;

/**
 * @author: lingjun.jlj
 * @date: 2019/6/21 14:27
 * @version：1.0
 * @description:
 */
public class PageDTO {

    private Integer start;
    private Integer size;


    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "PageDTO{" +
                "start=" + start +
                ", size=" + size +
                '}';
    }
}

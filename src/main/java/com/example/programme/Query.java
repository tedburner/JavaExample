package com.example.programme;

import com.example.programme.domain.PageDTO;

/**
 * @author: lingjun.jlj
 * @date: 2019/6/21 14:28
 * @version：1.0
 * @description:
 */
public class Query extends PageDTO {


    private String query;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    public String toString() {
        return super.toString() + "query=" + query;
    }
}

package com.example.reactive.reactive_design.chapter03;

import java.util.Date;

/**
 * @author: Arthas
 * @date: 2019-01-10 14:36
 * @description:
 */
public class Unsafe {

    private Date timestamp;
    private final StringBuffer message;

    public Unsafe (Date timestamp, StringBuffer message){
        this.timestamp =timestamp;
        this.message = message;
    }

    public synchronized Date getTimestamp() {
        return timestamp;
    }

    public synchronized void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public StringBuffer getMessage() {
        return message;
    }
}

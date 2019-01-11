package com.example.reactive.chapter03;

import java.util.Date;

/**
 * @author: Arthas
 * @date: 2019-01-10 18:58
 * @description:
 */
public class Immutable {

    private final Date timestamp;
    private final String message;

    public Immutable(final Date timestamp, final String message) {
        this.timestamp = new Date(timestamp.getTime());
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }


    public static void main(String[] args) {
        Immutable immutable = new Immutable(new Date(), "Hello World");

        Immutable immutable1 = new Immutable(new Date(), "Hello World");
    }
}

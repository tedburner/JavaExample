package com.example.programme.domain;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/15 14:46
 * @description:
 */
public class CurrentUserHolder {

    private static final ThreadLocal<String> holder = new ThreadLocal<>();

    public static void set(String user) {
        holder.set(user);
    }

    public static String get() {
        return holder.get() == null ? "unknown" : holder.get();
    }

}

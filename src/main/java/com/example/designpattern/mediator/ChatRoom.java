package com.example.designpattern.mediator;

import java.util.Date;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/19 21:40
 * @Description:
 */
public class ChatRoom {

    public static void showMessage(User user, String message) {
        System.out.println(new Date().toString()
                + " [" + user.getName() + "] : " + message);
    }
}

package com.example.DesignPatterns.MediatorPattern;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/19 21:40
 * @Description:
 */
public class User {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name){
        this.name  = name;
    }

    public void sendMessage(String message){
        ChatRoom.showMessage(this,message);
    }

}

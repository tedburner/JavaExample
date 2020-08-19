package com.example.netty.juejin_study.part8.protocol.command;

import lombok.Data;

import static com.example.netty.juejin_study.part8.protocol.command.Command.LOGIN_REQUEST;

/**
 * @author: lingjun.jlj
 * @date: 2019-01-11 13:53
 * @description:
 */
public class LoginRequestPacket extends Packet {

    private String userId;

    private String username;

    private String password;

    @Override
    public Byte getCommand() {
        return LOGIN_REQUEST;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginRequestPacket{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                "} " + super.toString();
    }
}

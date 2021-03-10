package com.example.spring.ioc.domain;

import com.example.spring.ioc.annotation.Super;

/**
 * @author: lingjun.jlj
 * @date: 2020/5/17 20:53
 * @description:
 */
@Super
public class SuperUser extends User{

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}

package com.example.algorithm.leetcode.code;

/**
 * @author: lingjun.jlj
 * @date: 2021/3/20 22:09
 * @description: 1603 设计停车场系统
 * 要求：carType 三种车辆，大中小，分别用1 2 3 标识，一辆车只能停在cardType对应尺寸的停车位
 */
public class ParkingSystem {

    int big;
    int medium;
    int small;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        // 如果有大车要停
        if (carType == 1) {
            // 判断大号车位是否有空余
            if (big <= 0) {
                return false;
            }
            this.big = this.big - 1;
            return true;
        }
        // 中车
        if (carType == 2) {
            // 判断中车位是否有空余
            if (this.medium <= 0) {
                return false;
            }
            this.medium = this.medium - 1;
            return true;
        }
        // 小车
        if (carType == 3) {
            // 判断小车位是否有空余
            if (this.small <= 0) {
                return false;
            }
            this.small = this.small - 1;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);

    }
}

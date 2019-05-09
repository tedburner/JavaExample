package com.example.test;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author: Arthas
 * @date: 2019-04-29 22:59
 * @description:
 */
public class RandomTest {

    public static String getRandom() {
        int randomNumber = randomInt();
        return String.valueOf(randomNumber);
    }

    /**
     * 随机生成6位随机数
     */
    private static int randomInt() {
        Random random = new Random();
        int x = random.nextInt(899999);
        System.out.println("随机生成的数字：" + x);
        x = x + 100000;
        return x;
    }

    /**
     * 为每个线程生成一个随机数
     */
    public static int threadLocalRandom() {
        return ThreadLocalRandom.current().nextInt(1000000);
    }

    public static void main(String[] args) {
        System.out.println(getRandom());

        System.out.println(threadLocalRandom() + 100000);
    }
}

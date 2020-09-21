package com.example.algorithm.ali;

import java.util.LinkedList;

/**
 * @author: lingjun.jlj
 * @date: 2020/9/21 21:52
 * @description: 我手中有一堆扑克牌， 但是观众不知道它的顺序。
 * <p>
 * 1、第一步， 我从牌顶拿出一张牌， 放到桌子上。
 * <p>
 * 2、第二步， 我从牌顶再拿一张牌， 放在手上牌的底部。
 * <p>
 * 3、第三步， 重复第一步、第二步的操作， 直到我手中所有的牌都放到了桌子上
 * <p>
 * 观众可以看到桌子上牌的从上往下是：A 2 3 4 5 6 7 8 9 10 J K
 */
public class Card {

    public static void main(String[] args) {
        String[] desktop = new String[]{"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "K"};
        LinkedList<String> hand = new LinkedList<>();
        int length = desktop.length;
        //将手上的牌，从底部往上移除，放到手上的牌顶部，并将手上底部的牌移除到手上顶部
        for (int i = 0; i < length; i++) {
            //手上有牌，移除底部加入到顶部
            if (hand.size() > 0) {
                String str = hand.removeLast();
                hand.addFirst(str);
            }
            //将当前位置放到手上顶部
            hand.addFirst(desktop[i]);
        }
        for (String str : hand) {
            System.out.print(str + " ");
        }
    }

    public static LinkedList<Integer> findCardLocation(int[] location) {
        // 如果桌子上没牌
        if (location.length == 0) {
            return new LinkedList<>();
        }
        LinkedList<Integer> result = new LinkedList<>(); // 答案
        for (int i = location.length - 1; i >= 0; i--) {
            if (result.size() > 0) {
                result.addFirst(result.removeLast());// 从牌底部拿一张到牌顶
            }
            result.addFirst(location[i]);
        }
        return result;
    }
}

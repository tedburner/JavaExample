package com.example.algorithm.mianshi;

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
public class CardMove {

    public static void main(String[] args) {
        String[] desktop = new String[]{"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "K"};
        LinkedList<String> hand = new LinkedList<>();
        //从桌子的顶部开始，在手上有牌的情况下，先把底部的牌放到顶部，然后从桌子上顶部拿起一张牌放到手牌的顶部
        for (String s : desktop) {
            //手上有牌，移除底部加入到顶部
            if (hand.size() > 1) {
                String str = hand.removeLast();
                hand.addFirst(str);
            }
            //将当前位置放到手上顶部
            hand.addFirst(s);
        }
        hand.forEach(input -> System.out.println(input + " "));
    }
}

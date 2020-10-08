package com.example.algorithm.leetcode;

/**
 * @author: lingjun.jlj
 * @date: 2020/10/6 09:20
 * @description: 宝石与石头
 * <href=https://leetcode-cn.com/problems/jewels-and-stones/ />
 */
public class Code771 {

    public static int numJewelsInStones(String J, String S) {
        int ans = 0;
        for (int i = 0; i < S.length(); i++) {
            for (int j = 0; j < J.length(); j++) {
                if (S.charAt(i) == J.charAt(j)) {
                    ans++;
                    continue;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String J = "z", S = "ZZ";
        System.out.println(numJewelsInStones(J, S));
    }
}

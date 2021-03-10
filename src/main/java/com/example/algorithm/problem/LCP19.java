package com.example.algorithm.problem;

/**
 * @author: lingjun.jlj
 * @date: 2020/10/1 20:06
 * @description: 秋叶收藏集
 * <href=https://leetcode-cn.com/problems/UlBDOe//>
 */
public class LCP19 {

    public int minimumOperations(String leaves) {
        int length = leaves.length();
        boolean flag = false;
        int ans = 0;
        for (int i = 0; i < length; i++) {
            Character ch = leaves.charAt(i);
            if (ch == 'y' && !flag) {
                flag = true;
            }
            if (ch == 'r' && flag) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String leaves = "rrryyyrryyyrr";
        int step = new LCP19().minimumOperations(leaves);
        System.out.println(step);
    }
}

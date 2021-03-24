package com.example.algorithm.leetcode.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2020/9/13 16:44
 * @description: 单词搜索 II 未完成
 */
public class Code212 {

    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            for (int x = 0; x < board.length; x++) {
                for (int y = 0; y < board[0].length; y++) {
                    if (find(board, x, y, word, 0)) {
                        ans.add(0, word);
                    }
                }
            }
        }
        return ans;
    }

    public boolean find(char[][] board, int x, int y, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != word.charAt(index)) {
            return false;
        }
        char c = board[x][y];
        board[x][y] = '#';
        boolean flag = find(board, x - 1, y, word, index + 1) ||
                find(board, x + 1, y, word, index + 1) ||
                find(board, x, y - 1, word, index + 1) ||
                find(board, x, y + 1, word, index + 1);
        board[x][y] = c;
        return flag;
    }

    public static void main(String[] args) {
//        String[] words = {"oath", "pea", "eat", "rain"};
//        char[][] board = {{'o', 'a', 'a', 'n'},
//                {'e', 't', 'a', 'e'},
//                {'i', 'h', 'k', 'r'},
//                {'i', 'f', 'l', 'v'}};
        char[][] board = {{'a', 'a'}};
        String[] words = {"a"};
        System.out.println(new Code212().findWords(board, words));
    }
}

package com.example.algorithm.leetcode;

/**
 * @author: lingjun.jlj
 * @date: 2020/9/13 15:58
 * @description: 单词搜索
 * 方法：遍历二维数组，判断当前位置的字符是否是首字母相同，然后递归遍历当前位置的前后左右位置，是否和接下来的字母相同
 */
public class Code79 {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param board 数组
     * @param x     坐标x
     * @param y     坐标y
     * @param word  字符串
     * @param index 当前字符串下标
     * @return
     */
    public boolean exist(char[][] board, int x, int y, String word, int index) {
        //判断字符串是否遍历完成
        if (index == word.length()) {
            return true;
        }
        //判断x,y坐标是否越界，以及当前位置是否相等
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != word.charAt(index)) {
            return false;
        }
        char c = board[x][y];
        //标记当前位置已经遍历
        board[x][y] = '#';
        boolean flag = exist(board, x - 1, y, word, index + 1) ||
                exist(board, x + 1, y, word, index + 1) ||
                exist(board, x, y - 1, word, index + 1) ||
                exist(board, x, y + 1, word, index + 1);
        //回溯完成后，复原，当前位置
        board[x][y] = c;
        return flag;
    }


    public static void main(String[] args) {
        Code79 code = new Code79();
        char[][] board = {{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
        System.out.println(code.exist(board, "AAB"));
    }
}

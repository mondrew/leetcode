package com.leetcode.companies.capital_one.candy_crush;

/**
 * LeetCode 723. Candy Crush
 * https://just4once.gitbooks.io/leetcode-notes/content/leetcode/two-pointers/723-candy-crush.html
 */
public class Solution {

    public int[][] candyCrush(int[][] board) {
        int r = board.length, c = board[0].length;
        boolean crush = false;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                // check horizontal line
                int v = Math.abs(board[i][j]);
                if (v == 0) continue;
                if (j + 2 < c && v == Math.abs(board[i][j + 1]) && v == Math.abs(board[i][j + 2])) {
                    crush = true;
                    board[i][j] = board[i][j + 1] = board[i][j + 2] = -v;
                }
                // check vertical line
                if (i + 2 < r && v == Math.abs(board[i + 1][j]) && v == Math.abs(board[i + 2][j])) {
                    crush = true;
                    board[i][j] = board[i + 1][j] = board[i + 2][j] = -v;
                }
            }
        }
        // crush candy
        for (int j = 0; j < c; j++) {
            int id = r - 1;
            for (int i = r - 1; i >= 0; i--) {
                if (board[i][j] > 0) {
                    board[id--][j] = board[i][j];
                }
            }
            while (id >= 0) {
                board[id--][j] = 0;
            }
        }
        return crush ? candyCrush(board) : board;
    }

    public static void main(String[] args) {

    }
}
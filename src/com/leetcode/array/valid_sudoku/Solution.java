package com.leetcode.array.valid_sudoku;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    /**
     * Beautiful and short String solution
     */
    public static boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!seen.add("Row " + "[" + i + "] => " + board[i][j]) ||
                        !seen.add("Column " + "[" + j + "] => " + board[i][j]) ||
                        !seen.add("Box " + "[" + (i / 3) + "][" + (j / 3) + "] => " + board[i][j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    /**
     * Easy but long solution.
     */
    public static boolean isValidSudoku2(char[][] board) {
        return isRowsValid(board) && isColumnsValid(board) && isBoxesValid(board);
    }

    private static boolean isBoxesValid(char[][] board) {
        // Checks repetitions in Boxes + 1-9 chars
        Set<Character> set = new HashSet<>();
        for (int ki = 0; ki < 9; ki += 3) {
            set.clear();
            for (int kj = 0; kj < 9; kj += 3) {
                set.clear();
                for (int i = ki; i < ki + 3; i++) {
                    for (int j = kj; j < kj + 3; j++) {
                        char c = board[i][j];
                        if (c == '.') {
                            continue;
                        }
                        if (c < '1' || c > '9' || set.contains(c)) {
                            return false;
                        }
                        set.add(c);
                    }
                }
            }
        }
        return true;
    }

    private static boolean isColumnsValid(char[][] board) {
        // Checks repetitions in Columns + 1-9 chars
        Set<Character> set = new HashSet<>();
        for (int j = 0; j < 9; j++) {
            set.clear();
            for (int i = 0; i < 9; i++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                if (c < '1' || c > '9' || set.contains(c)) {
                    return false;
                }
                set.add(c);
            }
        }
        return true;
    }

    private static boolean isRowsValid(char[][] board) {
        // Checks repetitions in Rows + 1-9 chars
        Set<Character> set = new HashSet<>();
        for (char[] row : board) {
            set.clear();
            for (char c : row) {
                if (c == '.') {
                    continue;
                }
                if (c < '1' || c > '9' || set.contains(c)) {
                    return false;
                }
                set.add(c);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board =
                {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(isValidSudoku(board));
    }
}

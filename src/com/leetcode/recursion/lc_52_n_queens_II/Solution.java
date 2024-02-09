package com.leetcode.recursion.lc_52_n_queens_II;

import java.util.HashSet;
import java.util.Set;

class Solution {

    private int size;
    private Set<Integer> columnSet = new HashSet<>();
    private Set<Integer> diagonalSet = new HashSet<>();
    private Set<Integer> antiDiagonalSet = new HashSet<>();

    private int backtrack(int row) {
        if (row == size) {
            return 1;
        }
        int solutions = 0;
        for (int col = 0; col < size; col++) {
            int currDiagonal = row - col;
            int currAntiDiagonal = row + col;
            if (!columnSet.contains(col) &&
                    !diagonalSet.contains(currDiagonal) &&
                    !antiDiagonalSet.contains(currAntiDiagonal)) {
                // Place the Queen
                columnSet.add(col);
                diagonalSet.add(currDiagonal);
                antiDiagonalSet.add(currAntiDiagonal);
                solutions += backtrack(row + 1);

                // Remove the Queen
                columnSet.remove(col);
                diagonalSet.remove(currDiagonal);
                antiDiagonalSet.remove(currAntiDiagonal);
            }
        }
        return solutions;
    }

    public int totalNQueens(int n) {
        size = n;
        return backtrack(0);
    }
}
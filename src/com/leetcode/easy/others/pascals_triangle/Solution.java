package com.leetcode.easy.others.pascals_triangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private static List<Integer> generateNumForTheRow(List<Integer> prevRow, int rowNum) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 1; i < rowNum; i++) {
            row.add(prevRow.get(i - 1) + prevRow.get(i));
        }
        row.add(1);
        return row;
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        triangle.add(firstRow);
        for (int i = 1; i < numRows; i++) {
            triangle.add(generateNumForTheRow(triangle.get(i - 1), i));
        }
        return triangle;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}

package com.leetcode.arrays101.even_number_of_digits;

public class Solution {
    public static int findNumbers(int[] nums) {
        int evenCounter = 0;
        for (int n : nums) {
            int i = 1;
            while (n / 10 > 0) {
                n = n / 10;
                i++;
            }
            if (i % 2 == 0) {
                evenCounter++;
            }
        }
        return evenCounter;
    }

    public static void main(String[] args) {
        int[] nums = {12, 345, 2, 6, 7896};
        System.out.println(findNumbers(nums));
    }
}

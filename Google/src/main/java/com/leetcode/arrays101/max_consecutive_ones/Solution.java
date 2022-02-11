package com.leetcode.arrays101.max_consecutive_ones;

public class Solution {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int current = 0;
        int max = 0;
        for (int n : nums) {
            if (n == 1) {
                current++;
            } else {
                max = Math.max(max, current);
                current = 0;
            }
        }
        return Math.max(max, current);
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
}
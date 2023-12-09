package com.leetcode.medium.array_and_strings.increasing_triplet_subseq;

public class Solution {

    // start with two largest values, as soon as we find a number bigger than both, while both have been updated, return true.
    public static boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE;
        int big = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= small) {
                small = n;
            } else if (n <= big) {
                big = n;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(increasingTriplet(nums));
    }
}
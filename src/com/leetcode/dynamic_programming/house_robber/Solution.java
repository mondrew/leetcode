package com.leetcode.dynamic_programming.house_robber;

public class Solution {

    public static int rob(int[] nums) {
        /**
         A[0] - [2] -> 2
         A[1] - [2, 1] -> 2
         A[2] - [2, 1, 1] -> 3
         A[3] - [2, 1, 1, 2] -> 4
         A[4] - [2, 1, 1, 2, 500] -> 503

         A[0] - [1] -> 1
         A[1] - [1, 300] -> 300
         A[2] - [1, 300, 1] -> 300
         A[3] - [1, 300, 1, 2] -> 302
         A[4] - [1, 300, 1, 2, 1] -> 302
         A[5] - [1, 300, 1, 2, 1, 600] -> 902

         A[i] = max(A[i - 2] + A[i], A[i - 1])
         */
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int[] nums2 = {2, 7, 9, 3, 1, 1};
        System.out.println(rob(nums));
    }
}

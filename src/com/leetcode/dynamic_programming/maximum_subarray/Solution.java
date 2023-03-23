package com.leetcode.dynamic_programming.maximum_subarray;

public class Solution {

    public static int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int maxSum = nums[0];
        int[] sumArr = new int[nums.length];
        sumArr[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sumArr[i] = nums[i] + Math.max(0, sumArr[i - 1]);
            maxSum = Math.max(maxSum, sumArr[i]);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums2 = {-2, 1};
        System.out.println(maxSubArray(nums2));
    }
}

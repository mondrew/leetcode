package com.leetcode.dynamic_programming.house_robber;

import java.util.Arrays;

public class Solution {

    /**
     * Algorithm                                <br>
     * A[0] - [1] -> 1                          <br>
     * A[1] - [1, 300] -> 300                   <br>
     * A[2] - [1, 300, 1] -> 300                <br>
     * A[3] - [1, 300, 1, 2] -> 302             <br>
     * A[4] - [1, 300, 1, 2, 1] -> 302          <br>
     * A[5] - [1, 300, 1, 2, 1, 600] -> 902     <br>
     * Result formula:                          <br>
     * A[i] = max(A[i - 2] + A[i], A[i - 1])    <br>
     * Time complexity: O(n);
     **/
    public static int rob(int[] nums) {
        int[] bank = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                bank[i] = nums[i];
            } else if (i == 1) {
                bank[i] = Math.max(nums[i - 1], nums[i]);
            } else {
                bank[i] = Math.max(bank[i - 2] + nums[i], bank[i - 1]);
            }
        }
        return bank.length != 0 ? bank[bank.length - 1] : 0;
    }

    /**
     * Better space complexity: O(1);
     */
    public static int rob2(int[] nums) {
        int prev = 0;
        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            int exCurrent = current;
            if (i == 0) {
                current = nums[i];
            } else if (i == 1) {
                current = Math.max(nums[i - 1], nums[i]);
            } else {
                current = Math.max(prev + nums[i], current);
            }
            prev = exCurrent;
        }
        return nums.length != 0 ? current : 0;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int[] nums2 = {2, 7, 9, 3, 1, 1};
        System.out.println(rob(nums2));
    }
}

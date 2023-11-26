package com.leetcode.easy.array.move_zeroes;

import java.util.Arrays;

public class Solution {

    /**
     * Second short a little longer solution.
     */
    public static void moveZeroes(int[] nums) {
        int insertPos = 0;
        for (int n : nums) {
            if (n != 0) {
                nums[insertPos++] = n;
            }
        }
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    /**
     * First fast solution.
     */
    public static void moveZeroes2(int[] nums) {
        int i = 0;
        while (i < nums.length && nums[i] != 0) {
            i++;
        }
        int j = i;
        while (j < nums.length) {
            if (nums[j] != 0) {
                nums[i++] = nums[j];
            }
            j++;
        }
        while (i < nums.length) {
            nums[i++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        int[] nums2 = {0};
        int[] nums3 = {1};
        moveZeroes(nums2);
        System.out.println(Arrays.toString(nums2));
    }
}

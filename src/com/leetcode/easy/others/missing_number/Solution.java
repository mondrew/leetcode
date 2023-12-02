package com.leetcode.easy.others.missing_number;

import java.util.Arrays;

public class Solution {

    public static int missingNumber(int[] nums) {
        int expectedSum = nums.length * (nums.length + 1) / 2;
        int actualSum = Arrays.stream(nums).reduce(0, Integer::sum);
        return expectedSum - actualSum;
    }

    public static int missingNumber2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{3, 2, 0}));
    }
}

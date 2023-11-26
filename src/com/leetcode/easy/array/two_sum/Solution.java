package com.leetcode.easy.array.two_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * Fast and easy solution.
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[]{0, 1};
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] nums2 = {3, 2, 4};
        int target2 = 6;

        int[] nums3 = {3, 3};
        int target3 = 6;

        int[] nums4 = {0, 4, 3, 0};
        int target4 = 0;

        int[] nums5 = {-1, -2, -3, -4, -5};
        int target5 = -8;

        System.out.println(Arrays.toString(twoSum(nums5, target5)));
    }
}

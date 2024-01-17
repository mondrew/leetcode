package com.leetcode.companies.capital_one.three_sum_closest;

import java.util.Arrays;

/**
 * LeetCode 16. 3Sum Closest
 * https://leetcode.com/problems/3sum-closest/description/
 */
public class Solution {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                    closestSum = sum;
                }
                if (sum > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return closestSum;
    }

    public static void main(String[] args) {

    }
}
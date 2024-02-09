package com.leetcode.array_string.lc_27_remove_element;

/**
 * https://leetcode.com/problems/remove-element/description/
  */
public class Solution {

    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        return i;
    }
}
package com.leetcode.array.remove_duplicates_from_sorted_array;

class Solution {

    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 1;
        if (nums == null) {
            return (0);
        }
        else if (nums.length == 1) {
            return (1);
        }
        while (j < nums.length) {
            while (j < nums.length && nums[j] == nums[i]) {
                j++;
            }
            if (j < nums.length) {
                i++;
                nums[i] = nums[j];
                j++;
            }
        }
        return (i + 1);
    }
}

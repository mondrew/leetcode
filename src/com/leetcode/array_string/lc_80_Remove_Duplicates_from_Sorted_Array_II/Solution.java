package com.leetcode.array_string.lc_80_Remove_Duplicates_from_Sorted_Array_II;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 */
public class Solution {

    public int removeDuplicates(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            int value = map.getOrDefault(nums[j], 0);
            if (value < 2) {
                map.put(nums[j], value + 1);
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        return i;
    }
}
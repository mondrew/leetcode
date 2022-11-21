package com.leetcode.array.contains_duplicate;

import java.util.*;

public class Solution {

    /**
     * Best solution!!! <br>
     * Time: O(n)
     * Memory: O(n)
     */
    public static boolean containsDuplicate3(int[] nums) {
        return nums.length != Arrays.stream(nums)
                .distinct()
                .count();
    }

    /**
     * Simplest solution -> use HashSet<br>
     * Time: O(n).<br>
     * Memory: O(n).
     */
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.contains(n)) {
                return true;
            } else {
                set.add(n);
            }
        }
        return false;
    }

    /**
     * Sorting array.<br>
     * Time: O(n log n).
     * Memory: O(1) (without extra space used while sorting).
     */
    public static boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        int[] arr2 = {1, 2, 3, 4};
        System.out.println(containsDuplicate(arr));
    }
}

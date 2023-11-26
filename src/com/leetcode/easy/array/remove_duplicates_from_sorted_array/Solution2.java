package com.leetcode.easy.array.remove_duplicates_from_sorted_array;

public class Solution2 {

    /**
    We need two pointers:<br>
        1. Pointer that will go through all elements of the array to very end; It'll also skip duplicated elements<br>
        2. Pointer that will only record (rewrite) unique elements in the array
     */
    public static int removeDuplicates(int[] nums) {
        short lastIdx = 0;
        short i = 0;

        while (i < nums.length) {
            while (i < nums.length && nums[i] == nums[lastIdx]) {
                i++;
            }
            if (i < nums.length) {
                lastIdx++;
                nums[lastIdx] = nums[i];
            }
        }
        return lastIdx + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 2, 3, 3, 4, 4, 4, 4, 4, 4, 4, 5, 6, 7, 7, 7, 8};
        int[] arr2 = {1};
        int res = removeDuplicates(arr2);
        System.out.println(res);
    }
}

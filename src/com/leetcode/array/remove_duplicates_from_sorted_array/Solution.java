package com.leetcode.array.remove_duplicates_from_sorted_array;

public class Solution {

    /**
     * Time complexity : O(n), since we only have 2 pointers, and both the pointers will traverse the array at most once.<br>
     * Space complexity : O(1), since we are not using any extra space.
     */
    public static int removeDuplicates(int[] nums) {
        int insertIndex = 1;

        for (int i = 1; i < nums.length; i++) {
            // We skip to next index if we see a duplicate element
            if (nums[i] != nums[i - 1]) {
                /* Storing the unique element at insertIndex index and incrementing the insertIndex by 1 */
                nums[insertIndex++] = nums[i];
            }
        }
        return insertIndex;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 2, 3, 3, 4, 4, 4, 4, 4, 4, 4, 5, 6, 7, 7, 7, 8};
        int[] arr2 = {1};
        int res = removeDuplicates(arr);
        System.out.println(res);
    }
}

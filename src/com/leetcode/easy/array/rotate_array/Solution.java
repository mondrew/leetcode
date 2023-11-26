package com.leetcode.easy.array.rotate_array;

import java.util.Arrays;

public class Solution {

    /**
     * Using short temp array.<br>
     * Time: O(N).<br>
     * Memory: O(k).<br>
     * Best decision so far.
     */
    public static void rotateWithSmallTempArray(int[] nums, int k) {
        // If k > nums.length -> avoid useless work
        k = k % nums.length;
        // Copying first (nums.length - k) elements to temp array
        int[] temp = Arrays.copyOfRange(nums, 0, nums.length - k);

        // Copy tail of array to the head
        for (int i = nums.length - k; i < nums.length; i++) {
            nums[i - nums.length + k] = nums[i];
        }
        // Copy saved temp to tail
        for (int i = 0; i < nums.length - k; i++) {
            nums[i + k] = temp[i];
        }
    }

    /**
     * Using temporary full-size array.<br>
     * The worst method.<br>
     * Time: O(N).<br>
     * Memory: O(N).
     */
    public static void rotateWithBigTempArray(int[] nums, int k) {
        k = k % nums.length;
        int newIdx = 0;
        int[] copy = Arrays.copyOf(nums, nums.length);

        for (int i = 0; i < nums.length; i++) {
            newIdx = (i + k) % nums.length;
            nums[newIdx] = copy[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int[] arr2 = {-1, -100, 3, 99};
        rotateWithSmallTempArray(arr, 3);
        System.out.println(Arrays.toString(arr));
    }
}

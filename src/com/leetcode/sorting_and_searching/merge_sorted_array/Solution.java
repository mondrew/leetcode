package com.leetcode.sorting_and_searching.merge_sorted_array;

import java.util.Arrays;

public class Solution {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1;
        n--;
        m--;

        while (n >= 0 && m >= 0) {
            nums1[i--] = nums2[n] > nums1[m] ? nums2[n--] : nums1[m--];
        }

        while (n >= 0) {
            nums1[i--] = nums2[n--];
        }
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1;
        n--;
        m--;

        while (i >= 0) {
            if (n >= 0 && (m < 0 || nums2[n] >= nums1[m])) {
                nums1[i--] = nums2[n--];
            } else if (m >= 0) {
                nums1[i--] = nums1[m--];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}

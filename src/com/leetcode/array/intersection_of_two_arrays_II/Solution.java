package com.leetcode.array.intersection_of_two_arrays_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    /**
     * Basic solution.<br>
     * Time: O(n).<br>
     * Memory: O(n).
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> resultList = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                while (i < nums1.length && nums1[i] < nums2[j]) {
                    i++;
                }
            } else if (nums2[j] < nums1[i]) {
                while (j < nums2.length && nums2[j] < nums1[i]) {
                    j++;
                }
            } else {
                while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
                    resultList.add(nums1[i]);
                    i++;
                    j++;
                }
            }
        }
        return resultList.stream().mapToInt(n -> n).toArray();
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] nums3 = {4,9,5};
        int[] nums4 = {9,4,9,8,4};
        System.out.println(Arrays.toString(intersect(nums3, nums4)));
    }
}

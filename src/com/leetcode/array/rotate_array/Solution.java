package com.leetcode.array.rotate_array;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void rotate(int[] nums, int k) {

        if (k == 0) {
            return ;
        }
        int temp = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            int newIdx = (j + k) % nums.length;
            temp = nums[]
        }
    }

    public static void main(String [] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        rotate(nums, 2);
        System.out.println(Arrays.toString(nums));
    }
}

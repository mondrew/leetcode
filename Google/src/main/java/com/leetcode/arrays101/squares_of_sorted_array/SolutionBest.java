package com.leetcode.arrays101.squares_of_sorted_array;

import java.util.Arrays;

public class SolutionBest {

    public static int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            int leftSquared = (int) Math.pow(left, 2);
            int rightSquared = (int) Math.pow(right, 2);
            if (leftSquared >= rightSquared) {
                res[i] = leftSquared;
                left++;
            } else {
                res[i] = rightSquared;
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = {-4,-1,0,3,10};
        System.out.println(Arrays.toString(sortedSquares(array)));
    }
}

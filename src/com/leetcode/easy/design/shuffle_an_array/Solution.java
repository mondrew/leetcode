package com.leetcode.easy.design.shuffle_an_array;

import java.util.Arrays;
import java.util.Random;

public class Solution {

    private int[] nums;
    private int[] shuffled;
    private Random random = new Random();

    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        shuffled = Arrays.copyOf(nums, nums.length);
        for (int i = 0; i < nums.length - 1; i++) {
            int swapIdx = random.nextInt(i, nums.length);
            int n = shuffled[i];
            shuffled[i] = shuffled[swapIdx];
            shuffled[swapIdx] = n;
        }
        return shuffled;
    }

    public int[] getNums() {
        return nums;
    }

    public void setNums(int[] nums) {
        this.nums = nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution solution = new Solution(nums);
        System.out.println(Arrays.toString(solution.getNums()));
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.reset()));
        System.out.println(Arrays.toString(solution.shuffle()));
    }
}

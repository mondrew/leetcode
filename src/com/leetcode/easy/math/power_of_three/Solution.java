package com.leetcode.easy.math.power_of_three;

public class Solution {

    public static boolean isPowerOfThree(int n) {
        boolean isPower = false;
        if (n < 0) {
            return false;
        }
        for (int x = 0; x < 20; x++) {
            if (n == Math.pow(3, x)) {
                isPower = true;
                break;
            }
        }
        return isPower;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(23));
    }
}
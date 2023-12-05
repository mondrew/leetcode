package com.leetcode.easy.others.number_of_1_bits;

public class Solution {

    public static int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            result += n & 1;
            n >>>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(5));
    }
}

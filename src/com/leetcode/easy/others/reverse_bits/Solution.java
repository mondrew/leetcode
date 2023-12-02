package com.leetcode.easy.others.reverse_bits;

public class Solution {

    public static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            if ((n & 1) == 1) {
                result++;
            }
            n >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(5));
    }
}

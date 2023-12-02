package com.leetcode.easy.others.number_of_bits;

public class Solution {

    public static int hammingWeight(int n) {
        int counter = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                counter++;
            }
            n >>>= 1;
        }
        return counter;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(5));
    }
}

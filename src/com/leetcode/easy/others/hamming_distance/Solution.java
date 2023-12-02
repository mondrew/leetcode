package com.leetcode.easy.others.hamming_distance;

public class Solution {

    public static int hammingDistance(int x, int y) {
        int diff = x ^ y;
        int distance = 0;
        while (diff != 0) {
            distance += diff & 1;
            diff >>= 1;
        }
        return distance;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }
}

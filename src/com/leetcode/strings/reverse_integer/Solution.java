package com.leetcode.strings.reverse_integer;

public class Solution {

    /**
     * Simple and fast solution.<br>
     * Without Strings
     */
    public static int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int resPrev = res;
            res = res * 10 + x % 10;
            if ((res - x % 10) / 10 != resPrev) {
                return 0;
            }
            x /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        int x = 123;
        int x2 = -123;
        int x3 = 120;
        int x4 = Integer.MAX_VALUE;
        int x5 = 1534236469;
        System.out.println(reverse(x5));
    }
}
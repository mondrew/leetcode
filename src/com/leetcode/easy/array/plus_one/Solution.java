package com.leetcode.easy.array.plus_one;

import java.util.Arrays;

public class Solution {

    /**
     * Genius solution.
     * Time: O(n).<br>
     * Memory: O(n).
     */
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }

    /**
     * Poor and ugly solution.<br>
     * Attention! See Constraints!<br>
     * 1 <= digits.length <= 100 <br>
     * 0 <= digits[i] <= 9 <br>
     * Can't use neither int nor long!!!
     */
    public static int[] plusOne2(int[] digits) {
        int resLength = Arrays.stream(digits).allMatch(n -> n == 9) ? digits.length + 1 : digits.length;
        int rem = 1;
        int[] res = new int[resLength];

        for (int i = digits.length - 1, j = resLength - 1; j >= 0; i--, j--) {
            if (rem == 1) {
                if (i >= 0 && digits[i] == 9) {
                    res[j] = 0;
                } else if (i >= 0) {
                    res[j] = digits[i] + 1;
                    rem = 0;
                } else {
                    res[j] = 1;
                }
            } else {
                res[j] = digits[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] digits = {9,8,9};
        int[] digits2 = {4,3,2,1};
        int[] digits3 = {9};
        int[] digits4 = {9,8,7,6,5,4,3,2,1,0};
        System.out.println(Arrays.toString(plusOne(digits4)));
    }
}

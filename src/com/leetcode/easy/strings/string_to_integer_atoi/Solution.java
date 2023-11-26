package com.leetcode.easy.strings.string_to_integer_atoi;

public class Solution {

    /**
     * First naive solution
     */
    public static int myAtoi(String s) {
        s = s.trim();
        long num = 0;
        int sign = 1;
        if (s.isBlank()) {
            return 0;
        }
        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            sign = s.charAt(0) == '+' ? 1 : -1;
            if (s.length() == 1) {
                return 0;
            }
            s = s.substring(1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                break;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > Integer.MAX_VALUE || num < Integer.MIN_VALUE) {
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }
        return (int)num * sign;
    }

    public static void main(String[] args) {
        String s = "42";
        String s2 = "   -42";
        String s3 = "4193 with words";
        String s4 = "-91283472332";
        String s5 = "2147483648";
        System.out.println(myAtoi(s5));
    }
}

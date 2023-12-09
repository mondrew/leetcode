package com.leetcode.medium.array_and_strings.count_and_say;

public class Solution {

    private static String build(String result) {
        StringBuilder sb = new StringBuilder();
        int p = 0;
        while (p < result.length()) {
            char val = result.charAt(p);
            int count = 0;
            while (p < result.length() && result.charAt(p) == val) {
                p++;
                count++;
            }
            sb.append(count);
            sb.append(val);
        }
        return sb.toString();
    }

    public static String countAndSay(int n) {
        if (n <= 0) {
            return "-1";
        }
        String result = "1";
        for (int i = 1; i < n; i++) {
            result = build(result);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }
}
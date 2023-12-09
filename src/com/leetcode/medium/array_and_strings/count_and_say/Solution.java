package com.leetcode.medium.array_and_strings.count_and_say;

public class Solution {

    private static String createNextString(String str) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < str.length()) {
            int count = 0;
            char c = str.charAt(i);
            while (i < str.length() && str.charAt(i) == c) {
                i++;
                count++;
            }
            sb.append(count);
            sb.append(c);
        }
        return sb.toString();
    }

    public static String countAndSay(int n) {
        String result = "1";
        for (int i = 1; i < n; i++) {
            result = createNextString(result);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }
}
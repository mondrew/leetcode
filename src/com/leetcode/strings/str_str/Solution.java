package com.leetcode.strings.str_str;

public class Solution {

    /**
     * Elegant Java Solution
     *
     */
    public static int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) {
                    return i;
                } else if (i + j == haystack.length()) {
                    return -1;
                } else if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
        }
    }

    /**
     * First naive solution
     */
    public static int strStr2(String haystack, String needle) {
        int i = 0;
        while (i < haystack.length()) {
            int j = 0;
            if (haystack.charAt(i) == needle.charAt(j)) {
                while (i < haystack.length() && j < needle.length() && haystack.charAt(i) == needle.charAt(j)) {
                    i++;
                    j++;
                }
                if (j == needle.length()) {
                    return i - needle.length();
                } else if (i == haystack.length()) {
                    return -1;
                } else {
                    i = i - j + 1;
                }
            } else {
                i++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "sadbutsad";
        String needle = "sad";
        String haystack2 = "leetcode";
        String needle2 = "leeto";
        System.out.println(strStr(haystack2, needle2));
    }
}

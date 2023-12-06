package com.leetcode.medium.array_and_strings.longest_substr_wo_repeat_chars;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int maxLength = 1;
        int i = 0;
        int j = 0;
        Set<Character> set = new HashSet<>();
        while (i < s.length()) {
            while (j < s.length() && !set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
            }
            maxLength = Math.max(maxLength, j - i);
            if (j == s.length()) {
                break;
            }
            while (i < j && set.contains(s.charAt(j))) {
                set.remove(s.charAt(i++));
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
package com.leetcode.medium.array_and_strings.longest_substr_wo_repeat_chars;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 1;
        int i = 0;
        int j = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (i < s.length() && j < s.length()) {
            while (j < s.length() && !map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), 1);
                j++;
            }
            if (j == s.length()) {
                int size = j - i;
                maxLength = Math.max(maxLength, size);
            }

            if (map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), 2);
            } else {
                map.put(s.charAt(j), 1);
                maxLength
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
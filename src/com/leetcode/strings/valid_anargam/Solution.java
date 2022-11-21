package com.leetcode.strings.valid_anargam;

import java.util.Arrays;

public class Solution {

    /**
     * First solution: 2 arrays<br>
     * 1) 2 array for each word<br>
     * 2) Count number of each letter in both words<br>
     * 3) Compare two arrays.<br>
     * Faster and more effective than second solution.
     */
    public static boolean isAnagram(String s, String t) {
        int[] sLetters = new int[26];
        int[] tLetters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sLetters[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            tLetters[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (sLetters[i] != tLetters[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Second solution: Sorted arrays<br>
     * 1) Strings -> arrays<br>
     * 2) Sort arrays<br>
     * 3) Arrays -> toStrings<br>
     * 4) Check if strings equals<br>
     */
    public static boolean isAnagram2(String s, String t) {
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        Arrays.sort(sCharArray);
        Arrays.sort(tCharArray);
        return Arrays.equals(sCharArray, tCharArray);
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }
}

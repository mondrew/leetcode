package com.leetcode.medium.array_and_strings.longest_palindrom_substr;

public class Solution {

    /**
     * Time complexity : ***O(n^2)***. Since expanding a palindrome around its center could take O(n) time, the overall complexity is O(n^2).
     * <br>Space complexity : ***O(1)***.
     */
    public static String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        String longestPalindrome = s.substring(0, 1);
        for (int i = 0; i < s.length() - 1; i++) {
            String even = createPalindromeFromCenter(s, i, i);
            String odd = createPalindromeFromCenter(s, i, i + 1);
            if (even.length() > longestPalindrome.length()) {
                longestPalindrome = even;
            }
            if (odd.length() > longestPalindrome.length()) {
                longestPalindrome = odd;
            }
        }
        return longestPalindrome;
    }

    private static String createPalindromeFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("ccc"));
    }
}
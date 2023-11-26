package com.leetcode.easy.strings.valid_palindrome;

public class Solution {

    /**
     * Best solution
     */
    public static boolean isPalindrome(String s) {
        int head = 0;
        int tail = s.length() - 1;
        while (head < tail) {
            if (!Character.isLetterOrDigit(s.charAt(head))) {
                head++;
            } else if (!Character.isLetterOrDigit(s.charAt(tail))) {
                tail--;
            } else {
                if (Character.toLowerCase(s.charAt(head)) != Character.toLowerCase(s.charAt(tail))) {
                    return false;
                }
                head++;
                tail--;
            }
        }
        return true;
    }

    /**
     * Easy solution
     */
    public static boolean isPalindrome2(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z' || c >= '0' && c <= '9') {
                sb.append(c);
            }
        }
        char[] charArray = sb.toString().toCharArray();
        for (int i = 0; i < (charArray.length + 1) / 2; i++) {
            if (charArray[i] != charArray[charArray.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Regex solution.
     */
    public static boolean isPalindrome3(String s) {
        String newS = s
                .toLowerCase()
                .replaceAll("\\s+", "")
                .replaceAll("[^a-z0-9]", "");
        char[] charArray = newS.toCharArray();
        for (int i = 0; i < (charArray.length + 1) / 2; i++) {
            if (charArray[i] != charArray[charArray.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(s);
        String s2 = "race a car";
        String s3 = " ";
        System.out.println(isPalindrome(s3));
    }
}

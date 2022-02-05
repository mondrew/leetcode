package com.leetcode.google.license_key_formatting;

public class SolutionBest {

    public static String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != '-') {
                sb.append(sb.length() % (k + 1 ) == k ? "-" : "").append(s.charAt(i));
            }
        }
        return sb.reverse().toString().toUpperCase();
    }

    public static void main(String[] args) {
        String s1 = "5F3Z-2e-9-w";
        String s2 = "2-5g-3-J";
        System.out.println(licenseKeyFormatting(s1, 4));
        System.out.println(licenseKeyFormatting(s2, 2));
        System.out.println(licenseKeyFormatting("2", 2));
    }
}

package com.leetcode.google.license_key_formatting;

public class Solution {

    public static String licenseKeyFormatting(String s, int k) {
        s = s.replace("-", "").toUpperCase();
        int n = s.length();
        int numberOfGroups = s.length() / k;
        int remainder = s.length() % k;
        StringBuilder sb = new StringBuilder();
        if (remainder != 0) {
            sb.append(s, 0, remainder);
            if (numberOfGroups > 0) {
                sb.append("-");
            }
        }
        int i = remainder;
        while (numberOfGroups-- > 0) {
            sb.append(s, i, i + k);
            i += k;
            if (numberOfGroups > 0) {
                sb.append("-");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s1 = "5F3Z-2e-9-w";
        String s2 = "2-5g-3-J";
//        System.out.println(licenseKeyFormatting(s1, 4));
//        System.out.println(licenseKeyFormatting(s2, 2));
        System.out.println(licenseKeyFormatting("2", 2));
    }
}

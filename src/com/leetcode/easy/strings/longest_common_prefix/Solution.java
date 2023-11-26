package com.leetcode.easy.strings.longest_common_prefix;

import java.util.Arrays;

public class Solution {

    /**
     * Fast solution with sorting
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs);
        for (int i = 0; i < strs[0].length(); i++) {
            if (strs[0].charAt(i) != strs[strs.length - 1].charAt(i)) {
                return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

    /**
     * Short good solution
     */
    public static String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].length() - 1 < i || j > 0 && strs[j].charAt(i) != strs[0].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    /**
     * First naive solution
     */
    public static String longestCommonPrefix3(String[] strs) {
        StringBuilder sb = new StringBuilder();
        if (strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }
        for (int i = 0; i < strs[0].length(); i++) {
            sb.append(strs[0].charAt(i));
            for (int j = 1; j < strs.length; j++) {
                if (!strs[j].startsWith(sb.toString())) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        String[] strs2 = {"ab", "a"};
        System.out.println(longestCommonPrefix(strs2));
    }
}

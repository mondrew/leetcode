package com.leetcode.easy.strings.reverse_string;

import java.util.Arrays;

public class Solution {

    public static void reverseString(char[] s) {
        for (int i = 0; i < (s.length + 1) / 2; i++) {
            char temp = s[i];
            int iOpposite = s.length - 1 - i;
            s[i] = s[iOpposite];
            s[iOpposite] = temp;
        }
    }

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        char[] s2 = {'H','a','n','n','a','h'};
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }
}

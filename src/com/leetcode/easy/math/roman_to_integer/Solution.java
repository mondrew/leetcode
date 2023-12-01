package com.leetcode.easy.math.roman_to_integer;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static int romanToInt(String s) {
        int result = 0;
        int current = 0;
        int prev = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            switch (s.charAt(i)) {
                case 'I' -> current = 1;
                case 'V' -> current = 5;
                case 'X' -> current = 10;
                case 'L' -> current = 50;
                case 'C' -> current = 100;
                case 'D' -> current = 500;
                case 'M' -> current = 1000;
            }
            if (current < prev) {
                result -= current;
            } else {
                result += current;
            }
            prev = current;
        }
        return result;
    }

    public static int romanToInt2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((i + 1) < s.length() && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                result -= map.get(s.charAt(i));
            } else {
                result += map.get(s.charAt(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("LVIII"));
    }
}
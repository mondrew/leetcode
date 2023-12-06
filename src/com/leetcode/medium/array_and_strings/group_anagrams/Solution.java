package com.leetcode.medium.array_and_strings.group_anagrams;

import java.util.*;

public class Solution {

    // Accepted
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sorted = String.valueOf(charArray);
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(s);
        }
        return map.values().stream().toList();
    }

    // Accepted
    // Complexity O(n*m * log(m))
    public static List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] alphabetKeyArray = new char[26];
            for (char c : s.toCharArray()) {
                alphabetKeyArray[c - 'a']++;
            }
            String alphabetKey = String.valueOf(alphabetKeyArray);
            if (!map.containsKey(alphabetKey)) {
                map.put(alphabetKey, new ArrayList<>());
            }
            map.get(alphabetKey).add(s);
        }
        return map.values().stream().toList();
    }

    public static void main(String[] args) {
        String[] strings = {"eat","tea","tan","ate","nat","bat"};
        groupAnagrams(strings);
    }
}

package com.leetcode.strings.first_unique_character_in_string;

import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {

    /**
     * Perfect fast solution.
     */
    public static int firstUniqChar(String s) {
        int[] frequency = new int['z' - 'a' + 1];
        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (frequency[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }


    /**
     * LinkedHashMap solution<br>
     * If meet char for the first time -> Put to the map with value = index;<br>
     * If meet again -> change value to -1;<br>
     * Using LinkedHashMap -> to save sequence
     */
    public static int firstUniqChar2(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (map.containsKey(charArray[i])) {
                map.put(charArray[i], -1);
            } else {
                map.put(charArray[i], i);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != -1) {
                return entry.getValue();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        String s2 = "loveleetcode";
        String s3 = "aabb";
        String s4 = "dddccdbba";
        System.out.println(firstUniqChar(s4));
    }
}

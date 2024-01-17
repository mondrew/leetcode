package com.leetcode.companies.capital_one.text_justification;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 68. Text Justification
 * https://leetcode.com/problems/text-justification/description/
 */
public class Solution {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;
        List<String> currentLine = new ArrayList<>();
        while (i < words.length) {
            int currentLineWidth = 0;
//            int currentLength = currentLine.stream()
//                    .map(String::length)
//                    .reduce(0, Integer::sum);
            while (currentLineWidth < maxWidth) {
                currentLine.add(words[i]);
                int currentLineWordLength = currentLine.stream()
                    .map(String::length)
                    .reduce(0, Integer::sum);
                int currentLineMinSpacesAmount = currentLine.size() - 1;
                currentLineWidth = currentLineWordLength + currentLineMinSpacesAmount;
            }
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
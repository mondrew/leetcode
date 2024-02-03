package com.leetcode.companies.bloomberg.lc_1614_maximum_nesting_depth_of_the_parentheses;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public int maxDepth(String s) {
        int result = 0;
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push('(');
            } else if (c == ')') {
                stack.poll();
            }
            result = Math.max(result, stack.size());
        }
        return result;
    }
}
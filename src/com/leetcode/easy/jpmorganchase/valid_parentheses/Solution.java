package com.leetcode.easy.jpmorganchase.valid_parentheses;

import java.util.*;

/**
 * @author Andrei Beseda
 * @version 2/10/2023
 */
public class Solution {

    public static boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                case '[':
                case '{':
                    deque.offerLast(c);
                    break;
                case')':
                    if (deque.isEmpty() || deque.pollLast() != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (deque.isEmpty() || deque.pollLast() != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if (deque.isEmpty() || deque.pollLast() != '{') {
                        return false;
                    }
                    break;
            }
        }
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }
}

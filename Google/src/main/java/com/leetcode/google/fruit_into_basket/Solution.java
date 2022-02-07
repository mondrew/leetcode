package com.leetcode.google.fruit_into_basket;

import java.util.*;

public class Solution {
    public static int totalFruit(int[] fruits) {
        int currentSum = 0;
        int finalSum = 0;
        int lastIdx = 0;
        int lastIdxInARow = 0;
        // @param map linked hash map (1st: fruit type; 2nd - amount of fruits)
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < fruits.length; i++) {
            Integer numberOfElements = map.get(fruits[i]);
            map.put(fruits[i], numberOfElements == null ? 1 : numberOfElements + 1);
            if (map.size() == 3) {
                // Count sum of the 1st and the 2nd baskets in Linked Map
                Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
                currentSum = iterator.next().getValue() + iterator.next().getValue();
                // Remove excess element
                iterator = map.entrySet().iterator();
                Map.Entry<Integer, Integer> entrySet = map.entrySet().iterator().next();
                Integer first = iterator.next().getKey();
                Integer second = iterator.next().getKey();
                int del = first.equals(fruits[lastIdx]) ? second : first;
                map.put(del == second ? first : second, lastIdxInARow);
                map.remove(del);
                finalSum = Math.max(finalSum, currentSum);
            }
            // Count amount of times the last tree was in a row
            lastIdxInARow = fruits[i] == fruits[lastIdx] ? lastIdxInARow + 1 : 1;
            lastIdx = i;
        }
        Iterator<Map.Entry<Integer, Integer>> iterator2 = map.entrySet().iterator();
        currentSum = 0;
        while (iterator2.hasNext()) {
            currentSum += iterator2.next().getValue();
        }
        finalSum = Math.max(finalSum, currentSum);
        return finalSum;
    }

    public static void main(String[] args) {
//        int[] fruits = {1, 2, 3, 2, 2};
        int[] fruits2 = {0, 1, 6, 6, 4, 4, 6};
//        System.out.println(totalFruit(fruits1));
        System.out.println(totalFruit(fruits2));
    }
}

package com.leetcode.companies.bloomberg.lc_1029_two_city_scheduling;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;

public class Solution {

    public int twoCitySchedCost(int[][] costs) {
        //              0    1    2    3    4    5
        // city A:      259, 448, 926, 184, 840, 577
        // city B:      770, 054, 667, 139, 118, 469
        // diff A-B:    -511, 394, 259, 45, 722, 108
        // diff A-B => how much company loses sending a person to city A instead of city B

        //   0      3       5       2       1       4
        // -511     45      108     259     394     722
        // First n -> A, last n -> B

        // 1. Sort array base on A-B difference
        // 2. Send first n people to city A, second N people to city B
        Arrays.sort(costs, Comparator.comparingInt(a -> a[0] - a[1]));
        int result = 0;
        for (int i = 0; i < costs.length / 2; i++) {
            result += costs[i][0];
        }
        LinkedHashMap<Integer, Integer> m = new LinkedHashMap<>();
        for (int i = costs.length / 2; i < costs.length; i++) {
            result += costs[i][1];
        }
        return result;
    }
}
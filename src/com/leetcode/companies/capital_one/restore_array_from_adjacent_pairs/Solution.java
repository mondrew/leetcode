package com.leetcode.companies.capital_one.restore_array_from_adjacent_pairs;

/**
 * 1743. Restore the Array From Adjacent Pairs
 * https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/description/
 */

import java.util.*;

/**
 * Input: adjacentPairs = [[2,1],[3,4],[3,2]]
 * Output: [1,2,3,4]
 * Solution:
 * 1. Create a Graph [1 -> [2], 2 -> [1, 3]... etc] using LinkedHashMap
 * 2. Find entries with only 1 elem - end and beginning
 * 3. Do DFS
 */
public class Solution {

    private void dfs(Map<Integer, List<Integer>> graph, Set<Integer> visited, int head, List<Integer> result) {
        if (visited.contains(head)) {
            return;
        }
        result.add(head);
        visited.add(head);
        for (int n : graph.get(head)) {
            dfs(graph, visited, n, result);
        }
    }

    public int[] restoreArray(int[][] adjacentPairs) {
        // Create a graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] pair : adjacentPairs) {
            List<Integer> list;
            // Add left
            if (graph.containsKey(pair[0])) {
                list = graph.get(pair[0]);
            } else {
                list = new ArrayList<>();
                graph.put(pair[0], list);
            }
            list.add(pair[1]);
            // Add right
            if (graph.containsKey(pair[1])) {
                list = graph.get(pair[1]);
            } else {
                list = new ArrayList<>();
                graph.put(pair[1], list);
            }
            list.add(pair[0]);
        }
        int head = graph.entrySet().stream()
                .filter(e -> e.getValue().size() == 1)
                .findFirst()
                .get()
                .getKey();
        Set<Integer> visited = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        dfs(graph, visited, head, result);
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {

    }
}
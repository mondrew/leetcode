package com.leetcode.companies.bloomberg.lc_797_all_paths_from_source_to_target;

import java.util.ArrayList;
import java.util.List;

// Use backtracking
public class Solution {

    private List<List<Integer>> helper(int idx, List<Integer> path, int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> newPath = new ArrayList<>(path);
        newPath.add(idx);
        if (idx == graph.length - 1) {
            result.add(newPath);
            return result;
        }
        if (graph[idx].length == 0) {
            return null;
        }
        for (int n : graph[idx]) {
            List<List<Integer>> childPaths = helper(n, newPath, graph);
            if (childPaths != null) {
                result.addAll(childPaths);
            }
        }
        return result;
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        for (int n : graph[0]) {
            List<Integer> path = new ArrayList<>();
            path.add(0);
            List<List<Integer>> paths = helper(n, path, graph);
            result.addAll(paths);
        }
        return result;
    }
}
package com.leetcode.companies.goldman_sachs.find_the_largest_tree;

import java.util.*;

/**
 * 1 Child can have only 1 Parent
 * Parent can have multiple Children
 * Find the root index of the biggest tree in the disconnected graph
 * If there is more than 1 - return the smallest root-index
 */
public class Solution {

    private static Map<Integer, List<Integer>> createParentToChildrenMap(Map<Integer, Integer> childToParentMap) {
        Map<Integer, List<Integer>> parentToChildrenMap = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : childToParentMap.entrySet()) {
            List<Integer> list;
            Integer parent = entry.getValue();
            if (parentToChildrenMap.containsKey(parent)) {
                list = parentToChildrenMap.get(parent);
            } else {
                list = new ArrayList<>();
                parentToChildrenMap.put(parent, list);
            }
            list.add(entry.getKey());
        }
        return parentToChildrenMap;
    }

    private static int getNumberOfNodes(int node, Map<Integer, List<Integer>> parentToChildrenMap) {
        if (!parentToChildrenMap.containsKey(node)) {
            return 1;
        }
        int result = 0;
        List<Integer> children = parentToChildrenMap.get(node);
        for (int c : children) {
            result += getNumberOfNodes(c, parentToChildrenMap);
        }
        return result;
    }

    public static int solution(Map<Integer, Integer> childToParentMap) {
        Map<Integer, List<Integer>> parentToChildrenMap = createParentToChildrenMap(childToParentMap);
        List<Integer> roots = parentToChildrenMap.keySet().stream()
                .filter(p -> !childToParentMap.containsKey(p))
                .toList();
        int maxNodes = 0;
        int maxNodesRootIdx = 0;
        for (int r : roots) {
            int numberOfNodes = getNumberOfNodes(r, parentToChildrenMap);
            if (numberOfNodes > maxNodes) {
                maxNodes = numberOfNodes;
                maxNodesRootIdx = r;
            } else if (numberOfNodes == maxNodes) {
                if (r < maxNodesRootIdx) {
                    maxNodesRootIdx = r;
                }
            }
        }
        return maxNodesRootIdx;
    }

    public static void main(String[] args) {
        Map<Integer, Integer> childToParentMap = new HashMap<>();
        childToParentMap.put(1, 2);
        childToParentMap.put(3, 4);
        System.out.println(solution(childToParentMap));
    }
}
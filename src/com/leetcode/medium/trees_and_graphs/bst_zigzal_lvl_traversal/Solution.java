package com.leetcode.medium.trees_and_graphs.bst_zigzal_lvl_traversal;

import com.leetcode.medium.trees_and_graphs.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private static final boolean LEFT_TO_RIGHT = true;
    private static final boolean RIGHT_TO_LEFT = false;

    public static int getTreeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSubtreeHeight = getTreeHeight(root.left) + 1;
        int rightSubtreeHeight = getTreeHeight(root.right) + 1;
        return Math.max(leftSubtreeHeight, rightSubtreeHeight);
    }

    public static void zigzagLevelOrderForLevel(TreeNode root, ArrayList<Integer> array, int lvl, boolean direction) {
        // If lvl == 0 -> means we reached the level we need
        // root != null -> we have node
        if (lvl == 0 && root != null) {
            array.add(root.val);
            return;
        }
        // root == null -> we don't have node
        if (root == null) {
            return;
        }
        if (direction == LEFT_TO_RIGHT) {
            zigzagLevelOrderForLevel(root.left, array, lvl - 1, direction);
            zigzagLevelOrderForLevel(root.right, array, lvl - 1, direction);
        } else {
            zigzagLevelOrderForLevel(root.right, array, lvl - 1, direction);
            zigzagLevelOrderForLevel(root.left, array, lvl - 1, direction);
        }
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        int treeHeight = getTreeHeight(root);
        for (int i = 0; i < treeHeight; i++) {
            ArrayList<Integer> array = new ArrayList<>();
            zigzagLevelOrderForLevel(root, array, i, i % 2 == 0);
            result.add(array);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4, node5, null);
        TreeNode node3 = new TreeNode(3, node4, null);
        TreeNode node2 = new TreeNode(2, node3, null);
        TreeNode node1 = new TreeNode(1, node2, null);
        List<List<Integer>> result = zigzagLevelOrder(node1);
    }
}
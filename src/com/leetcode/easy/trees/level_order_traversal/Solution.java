package com.leetcode.easy.trees.level_order_traversal;

import com.leetcode.easy.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        int treeHeight = calculateTreeHeight(root);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < treeHeight; i++) {
            result.add(getTreeValuesForLevel(root, i, new ArrayList<>()));
        }
        return result;
    }

    private static List<Integer> getTreeValuesForLevel(TreeNode root, int level, List<Integer> list) {
        if (level == 0) {
            list.add(root.val);
            return list;
        }
        if (root.left != null) {
            getTreeValuesForLevel(root.left, level - 1, list);
        }
        if (root.right != null) {
            getTreeValuesForLevel(root.right, level - 1, list);
        }
        return list;
    }

    private static int calculateTreeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = calculateTreeHeight(root.left);
        int rightHeight = calculateTreeHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        /*
            Tree: [3,9,20,null,null,15,7]
         */
        TreeNode secondChildLeft = new TreeNode(15);
        TreeNode secondChildRight = new TreeNode(7);
        TreeNode firstChildLeft = new TreeNode(9);
        TreeNode firstChildRight = new TreeNode(20, secondChildLeft, secondChildRight);
        TreeNode root = new TreeNode(3, firstChildLeft, firstChildRight);
        System.out.println(levelOrder(root));
    }
}
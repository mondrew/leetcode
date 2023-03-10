package com.leetcode.trees.symmetric_tree;

import com.leetcode.trees.TreeNode;

public class Solution {

    private static boolean isSymmetric(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return true;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        // todo
        return false;
    }

    public static void main(String[] args) {
        /*
            Tree: [1,2,2,3,4,4,3]
         */
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(3), new TreeNode(4)));
        System.out.println(isSymmetric(root));
    }
}

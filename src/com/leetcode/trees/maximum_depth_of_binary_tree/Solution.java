package com.leetcode.trees.maximum_depth_of_binary_tree;

import com.leetcode.trees.TreeNode;

public class Solution {

    public static int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));
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
        System.out.println(maxDepth(root));
        /*
            Tree: [1, null, 2]
         */
//        TreeNode firstChildRight = new TreeNode(2);
//        TreeNode root = new TreeNode(1, null, firstChildRight);
//        System.out.println(maxDepth(root));
    }
}
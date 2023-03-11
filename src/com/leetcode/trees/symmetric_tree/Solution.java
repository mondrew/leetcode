package com.leetcode.trees.symmetric_tree;

import com.leetcode.trees.TreeNode;

public class Solution {

    private static boolean isPartsSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (!(left != null && right != null && left.val == right.val)) {
            return false;
        }
        return isPartsSymmetric(left.left, right.right) && isPartsSymmetric(left.right, right.left);
    }

    private static boolean isSymmetric(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return true;
        }
        return isPartsSymmetric(root.left, root.right);
    }

    public static void main(String[] args) {
        /*
            Tree: [1,2,2,3,4,4,3]
         */
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        System.out.println(isSymmetric(root));
    }
}

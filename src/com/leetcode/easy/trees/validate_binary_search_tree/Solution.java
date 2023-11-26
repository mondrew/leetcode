package com.leetcode.easy.trees.validate_binary_search_tree;

import com.leetcode.easy.trees.TreeNode;

public class Solution {

    private static boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static void main(String[] args) {
        /*
            Tree: [2, 1, 3]
         */
//        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
//        System.out.println(isValidBST(root));
        /*
            Tree: [5,1,4,null,null,3,6]
         */
//        TreeNode root = new TreeNode(5, new TreeNode(1, null, null), new TreeNode(4, new TreeNode(3), new TreeNode(6)));
        TreeNode root = new TreeNode(5, new TreeNode(4, null, null), new TreeNode(6, new TreeNode(3), new TreeNode(7)));
        System.out.println(isValidBST(root));
    }
}

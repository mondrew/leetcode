package com.leetcode.easy.trees.bst_from_preorder_and_inorder;

import com.leetcode.medium.trees_and_graphs.TreeNode;

public class Solution {

    public static TreeNode buildSubTree(int preorderStart, int inorderStart, int inorderEnd, int[] preorder, int[] inorder) {
        if (preorderStart > preorder.length - 1 || inorderStart > inorderEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preorderStart]);
        int inorderCurrent = 0; // Index of the current root
        for (int i = inorderStart; i <= inorderEnd; i++) {
            if (inorder[i] == root.val) {
                inorderCurrent = i;
            }
        }
        root.left = buildSubTree(preorderStart + 1, inorderStart, inorderCurrent - 1, preorder, inorder);
        root.right = buildSubTree(preorderStart + (inorderCurrent - inorderStart) + 1, inorderCurrent + 1, inorderEnd, preorder, inorder);
        return root;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildSubTree(0, 0, inorder.length - 1, preorder, inorder);
    }

    public static void main(String[] args) {

    }
}
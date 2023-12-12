package com.leetcode.medium.trees_and_graphs.bst_inorder_traversal;

import com.leetcode.medium.trees_and_graphs.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public void inorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, result);
        result.add(root.val);
        inorderTraversal(root.right, result);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    public static void main(String[] args) {

    }
}
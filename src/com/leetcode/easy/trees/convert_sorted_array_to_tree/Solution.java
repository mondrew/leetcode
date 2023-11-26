package com.leetcode.easy.trees.convert_sorted_array_to_tree;

import com.leetcode.easy.trees.TreeNode;

public class Solution {

    private static TreeNode createTree(int[] nums, int first, int last) {
        if (first > last) {
            return null;
        }
        int mid = first + (last - first) / 2;
        TreeNode root = new TreeNode(nums[mid],
                createTree(nums, first, mid - 1),
                createTree(nums, mid + 1, last));
        return root;
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) {
            return null;
        }
        return createTree(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        /*
            Tree: [1,2,2,3,4,4,3]
         */
        int[] nums = {-10, -3, 0, 5, 9};
        System.out.println(sortedArrayToBST(nums));
    }
}

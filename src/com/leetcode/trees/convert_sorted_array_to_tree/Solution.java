package com.leetcode.trees.convert_sorted_array_to_tree;

import com.leetcode.trees.TreeNode;

public class Solution {

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) {
            return null;
        }
        return createTree(nums, 0, nums.length - 1);
    }

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

    public static void main(String[] args) {
        /*
            Tree: [1,2,2,3,4,4,3]
         */
        int[] nums = {-10,-3,0,5,9};
        System.out.println(sortedArrayToBST(nums));
    }
}

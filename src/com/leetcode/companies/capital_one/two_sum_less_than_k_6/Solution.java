package com.leetcode.companies.capital_one.two_sum_less_than_k_6;

import java.util.Arrays;

/**
 * LeetCode 1099. Two Sum Less Than K
 * https://wentao-shao.gitbook.io/leetcode/two-pointers/1099.two-sum-less-than-k
 */
public class Solution {

    public int twoSumLessThanK(int[] array, int K) {
        Arrays.sort(array);
        int i = 0;
        int j = array.length - 1;
        int ans = -1;
        while (i < j) {
            if (array[i] + array[j] >= K) {
                j--;
            } else {
                ans = Math.max(ans, array[i] + array[j]);
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
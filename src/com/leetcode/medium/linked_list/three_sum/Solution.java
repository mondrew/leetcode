package com.leetcode.medium.linked_list.three_sum;

import java.util.*;

public class Solution {

    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> resultSet = new HashSet<>();
        if (nums.length == 0) {
            return new ArrayList<>(resultSet);
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    resultSet.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                }
                else if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                }
            }
        }
        return new ArrayList<>(resultSet);
    }

    // Second passing solution
    public static List<List<Integer>> threeSum3(int[] nums) {
        int[] sortedNums = Arrays.stream(nums).sorted().toArray();
        Set<List<Integer>> resultSet = new HashSet<>();
        for (int i = 0; i < sortedNums.length; i++) {
            int target = -sortedNums[i];
            Set<Integer> valueToIndexSet = new HashSet<>();
            for (int j = i + 1; j < sortedNums.length; j++) {
                if (valueToIndexSet.contains(target - sortedNums[j])) {
                    List<Integer> list = new ArrayList<>();
                    list.add(sortedNums[i]);
                    list.add(sortedNums[j]);
                    list.add(target - sortedNums[j]);
                    resultSet.add(list.stream().sorted().toList());
                } else {
                    valueToIndexSet.add(sortedNums[j]);
                }
            }
        }
        return resultSet.stream().toList();
    }

    // Slow straight-forward solution
    public static List<List<Integer>> threeSum2(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        set.add(list.stream().sorted().toList());
                    }
                }
            }
        }
        return set.stream().toList();
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{1, 2, 3}));
    }
}

package com.leetcode.arrays101.squares_of_sorted_array;

import java.util.Comparator;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {

    public static int[] sortedSquares(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        list = list.stream().map(i -> i < 0 ? -i : i).collect(Collectors.toList());
        list.sort(Comparator.naturalOrder());
        list = list.stream().map(i -> i * i).collect(Collectors.toList());
        return list.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] array = {-4,-1,0,3,10};
        System.out.println(Arrays.toString(sortedSquares(array)));
    }
}

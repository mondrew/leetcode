package com.leetcode.arrays101.squares_of_sorted_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution2 {

    public static List<Integer> quickSort(List<Integer> array) {
        if (array.size() < 2) {
            return new ArrayList<>(array);
        } else if (array.size() == 2) {
            if (array.get(0) <= array.get(1)) {
                return new ArrayList<>(Arrays.asList(array.get(0), array.get(1)));
            } else {
                return new ArrayList<>(Arrays.asList(array.get(1), array.get(0)));
            }
        }
        int pivot = array.size() / 2;

        List<Integer> lessOrEqual = new ArrayList<>();
        List<Integer> more = new ArrayList<>();

        for (int i = 0; i < array.size(); i++) {
            if (i != pivot && array.get(i) <= array.get(pivot)) {
                lessOrEqual.add(array.get(i));
            } else if (i != pivot) {
                more.add(array.get(i));
            }
        }
        List<Integer> res = quickSort(lessOrEqual);
        res.add(array.get(pivot));
        res.addAll(quickSort(more));
        return res;
    }

    public static int[] sortedSquares(int[] nums) {
        int[] positive = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            positive[i] = nums[i] < 0 ? nums[i] * (-1) : nums[i];
        }
        List<Integer> sortedList = quickSort(Arrays.stream(positive).boxed().collect(Collectors.toList()));
        sortedList.sort(Comparator.naturalOrder());
        sortedList.stream().map(i -> i < 0 ? -i : i).collect(Collectors.toList());
        for (int i = 0; i < sortedList.size(); i++) {
            sortedList.add(sortedList.get(i) * sortedList.get(i));
        }
        return sortedList.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] array = {-4,-1,0,3,10};
        System.out.println(Arrays.toString(sortedSquares(array)));
    }
}

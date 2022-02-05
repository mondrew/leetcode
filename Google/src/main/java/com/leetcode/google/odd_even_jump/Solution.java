package com.leetcode.google.odd_even_jump;

import java.util.Map;
import java.util.TreeMap;

public class Solution {

//    public static int oddEvenJumps(int[] arr) {
//        int n = arr.length;
//        int res = 1;
//        boolean[] higher = new boolean[n];
//        boolean[] lower = new boolean[n];
//        higher[n - 1] = lower[n - 1] = true;
//        TreeMap<Integer, Integer> map = new TreeMap<>();
//        map.put(arr[n - 1], n - 1);
//        for (int i = n - 2; i >= 0; --i) {
//            Map.Entry<Integer, Integer> hi = map.ceilingEntry(arr[i]);
//            Map.Entry<Integer, Integer> lo = map.floorEntry(arr[i]);
//            if (hi != null) {
//                higher[i] = lower[hi.getValue()];
//            }
//            if (lo != null) {
//                lower[i] = higher[lo.getValue()];
//            }
//            if (higher[i]) {
//                res++;
//            }
//            map.put(arr[i], i);
//        }
//        return res;
//    }

    public static int oddEvenJumps(int[] arr) {
        int res = 1;
        int n = arr.length;
        boolean[] higher = new boolean[n];
        boolean[] lower = new boolean[n];

        higher[n - 1] = lower[n - 1] = true;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(arr[n - 1], n - 1);
        for (int i = n - 2; i >= 0; i--) {
            Map.Entry<Integer, Integer> hi = map.ceilingEntry(arr[i]);
            Map.Entry<Integer, Integer> lo = map.floorEntry(arr[i]);
            if (hi != null) {
                higher[i] = lower[hi.getValue()];
            }
            if (lo != null) {
                lower[i] = higher[lo.getValue()];
            }
            if (higher[i]) {
                res++;
            }
            map.put(arr[i], i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 3, 4, 2};
        System.out.println(oddEvenJumps(arr));
    }
}

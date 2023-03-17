package com.leetcode.sorting_and_searching.first_bad_version;

public class Solution {

    public static int firstBadVersion(int n) {
        int start = 1;
        int end = n;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (!isBadVersion(mid)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    public static boolean isBadVersion(int version) {
        return version >= 57;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(9573));
    }
}

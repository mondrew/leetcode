package com.leetcode.array.single_number;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    /**
     * MASTERPIECE<br>
     * ----------<br>
     * 00000000 result<br>
     * XOR<br>
     * 00001010 n1<br>
     * ----------<br>
     * 00001010 result<br>
     * XOR<br>
     * 00000101 n2<br>
     * ----------<br>
     * 00001111 result<br>
     * XOR<br>
     * 00001010 n1<br>
     * ----------<br>
     * 00000101 result<br>
     * XOR<br>
     * 00000101 n2<br>
     * ----------<br>
     * 00000000 result<br>
     */
    public static int singleNumberXOR(int[] nums) {
        int result = 0;
        for (int n : nums) {
            result ^= n;
        }
        return result;
    }

    /**
     * Best solution.<br>
     * Time: O(n log n).<br>
     * Space: O(1).
     */
    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }

    /**
     * Simplest solution.<br>
     * Time: O(n).<br>
     * Memory: O(n).
     */
    public static int singleNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.contains(n)) {
                set.remove(n);
            } else {
                set.add(n);
            }
        }
        return set.stream().findFirst().orElse(0);
    }


    public static void main(String[] args) {
        int[] nums = {2,2,1};
        int[] nums2 = {4,1,2,1,2};
        int[] nums3 = {1};
        System.out.println(singleNumber(nums3));
    }
}

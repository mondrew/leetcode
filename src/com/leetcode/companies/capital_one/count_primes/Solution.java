package com.leetcode.companies.capital_one.count_primes;

/**
 * LeetCode 204. Count Primes
 * https://leetcode.com/problems/count-primes/description/
 */
public class Solution {

    public int countPrimes(int n) {
        boolean[] nonPrimes = new boolean[n];
        for (int i = 2; i * i < n; i++) {
            if (!nonPrimes[i]) {
                for (int j = i * i; j < n; j = j + i) { // If we're at 5 in [2, 3, 4, 5] -> we already had 2*5, 3*5, 4*5. We don't need 5*2, 5*3, 5*4, so we start from 5*5.
                    nonPrimes[j] = true;
                }
            }
        }
        int result = 0;
        for (int i = 2; i < n; i++) {
            if (!nonPrimes[i]) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
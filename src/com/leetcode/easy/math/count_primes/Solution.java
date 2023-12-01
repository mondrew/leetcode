package com.leetcode.easy.math.count_primes;

public class Solution {

    public static int countPrimes(int n) {
        int counter = 0;
        boolean[] notPrime = new boolean[n + 1];
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                counter++;
                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(114));
    }
}
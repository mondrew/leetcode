package com.leetcode.easy.jpmorganchase.happy_number;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Andrei Beseda
 * @version 2/10/2023
 */
public class Solution {
    public static boolean isHappy(int n) throws InterruptedException {
        if (n == 1) {
            return true;
        }
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (true) {
            int newN = 0;
            while (n > 0) {
                newN += Math.pow(n % 10, 2);
                n /= 10;
            }
            if (newN == 1) {
                return true;
            } else if (!set.add(newN)) {
                return false;
            }
            n = newN;
            System.out.println(n);
            Thread.sleep(1000);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(isHappy(2));
    }
}

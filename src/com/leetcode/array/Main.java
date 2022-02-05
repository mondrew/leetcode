package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

class Main {
    public static int findPisanoPeriod(int m) {
        boolean found = false;
        List<Integer> remainders = new ArrayList<>();
        List<Integer> fib = new ArrayList<>();
        fib.add(0);
        fib.add(1);
        remainders.add(0);
        remainders.add(1);
        while (!found) {
            int n = fib.get(fib.size() - 1) + fib.get(fib.size() - 2);
            fib.add(n);
            remainders.add(n % m);
            // wait for 2
        }
    }

    public static void main(String[] args) {
    }
}

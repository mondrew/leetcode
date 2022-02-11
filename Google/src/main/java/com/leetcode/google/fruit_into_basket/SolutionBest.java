package com.leetcode.google.fruit_into_basket;

public class SolutionBest {

    public static int totalFruit(int[] tree) {
        int res = 0;
        int cur = 0;
        int count_b = 0;
        int a = 0 ;
        int b = 0;

        for (int c :  tree) {
            cur = c == a || c == b ? cur + 1 : count_b + 1;
            count_b = c == b ? count_b + 1 : 1;
            if (b != c) {
                a = b;
                b = c;
            }
            res = Math.max(res, cur);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] fruits = {0, 1, 6, 6, 4, 4, 6};
        System.out.println(totalFruit(fruits));
    }
}

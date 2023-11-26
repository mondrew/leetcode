package com.leetcode.easy.array.best_time_to_buy_and_sell_stock_II;

public class Solution {

    /**
     * === Peak Valley Approach===<br>
     * We find valley + find peak<br>
     * Sum of all these intervals gives maximum profit.<br>
     * Time: O(n).<br>
     * Memory: O(1).
     */
    public static int maxProfit(int[] prices) {
        int i = 0;
        int j = 1;
        int profit = 0;

        while (j < prices.length) {
            if (prices[j] >= prices[i]) {
                while (j + 1 < prices.length && prices[j + 1] >= prices[j]) {
                    j++;
                }
                profit += prices[j] - prices[i];
            }
            i = j++;
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {1, 2, 3, 4, 5};
        int[] prices3 = {7, 6, 4, 3, 1};
        int profit = maxProfit(prices3);
        System.out.println("Max profit: " + profit);
    }
}

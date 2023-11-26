package com.leetcode.easy.dynamic_programming.best_time_to_buy_and_sell_stocks;

public class Solution {

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buyIdx = 0;
        int sellIdx = 1;

        while (sellIdx < prices.length) {
            int profit = prices[sellIdx] - prices[buyIdx];
            if (profit > 0) {
                maxProfit = Math.max(profit, maxProfit);
                sellIdx++;
            } else {
                buyIdx = sellIdx++;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(prices2));
    }
}

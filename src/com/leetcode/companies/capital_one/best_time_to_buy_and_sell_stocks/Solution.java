package com.leetcode.companies.capital_one.best_time_to_buy_and_sell_stocks;

/**
 * LeetCode 121. Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 */
public class Solution {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int i = 0;
        int j = i + 1;
        while (j < prices.length) {
            if (prices[j] > prices[i]) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            } else {
                i = j;
            }
            j++;
        }
        return maxProfit;
    }

    public static void main(String[] args) {

    }
}
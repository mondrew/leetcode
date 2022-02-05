package com.leetcode.array.best_time_to_buy_and_sell_stock;

class Solution {

    public static int findMin(int[] prices, int i) {
        if (i == prices.length) {
            return -1;
        }
        while (i + 1 < prices.length && prices[i] > prices[i + 1]) {
            i++;
        }
        return i;
    }

    public static int findMax(int[] prices, int i) {
        if (i == prices.length) {
            return -1;
        }
        while (i + 1 < prices.length && prices[i] < prices[i + 1]) {
            i++;
        }
        return i;
    }

    public static int maxProfit(int[] prices) {
        int min = 0;
        int max = 0;
        int i = 0;
        int profit = 0;
        int sum = 0;

        if (prices == null || prices.length == 1) {
            return 0;
        }
        while (i < prices.length) {
            min = findMin(prices, i);
            if (min == -1) {
                return sum;
            }
            i = min + 1;
            max = findMax(prices, i);
            if (max == -1) {
                return sum;
            }
            i = max + 1;
            profit = prices[max] - prices[min];
            sum += profit;
        }
        return sum;
    }
}
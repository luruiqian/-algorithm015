package com.leetode.application;

class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int profile = 0;
        int size = prices.length;
        for (int i = 1; i < size; i++) {
            if (prices[i] > prices[i - 1]) {
                profile += prices[i] - prices[i - 1];
            }
        }
        return profile;
    }
}

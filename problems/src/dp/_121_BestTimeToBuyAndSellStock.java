package dp;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class _121_BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(prices[i] - minPrice, profit);
            minPrice = Math.min(minPrice, prices[i]);
        }

        return profit;
    }
}

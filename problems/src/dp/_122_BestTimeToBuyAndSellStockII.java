package dp;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
public class _122_BestTimeToBuyAndSellStockII {

    public int maxProfitDP(int[] prices) {
        int n = prices.length;
        int[] buy = new int[n];
        int[] sell = new int[n];
        sell[0] = 0;
        buy[0] = -prices[0];
        for (int i = 1; i < n; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        return sell[n - 1];
    }

    // greedy
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit = 0;
        for (int i = 1; i < n; i++) {
            int dailyProfit = prices[i] - prices[i - 1];
            if (dailyProfit > 0) {
                // accumulate daily positive profit
                profit += dailyProfit;
            }
        }
        return profit;
    }
}

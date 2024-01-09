package dp;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
public class _123_BestTimeToBuyAndSellStockIII {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        // dp[i][0]: until ith day, no operation
        // dp[i][1]: until ith day, first time hold one share
        // dp[i][2]: until ith day, first time sell off one share
        // dp[i][3]: until ith day, second time hold one share
        // dp[i][4]: until ith day, second time sell off one share

        int[][] dp = new int[n][5];
        dp[0][0] = 0;
        dp[0][1] = -prices[0]; // buy at day 1
        dp[0][2] = 0; // buy,sell
        dp[0][3] = -prices[0]; // buy,sell,buy at day 1
        dp[0][4] = 0; // buy,sell,buy,sell
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0]; // always 0
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }

        int maxProfit = Math.max(dp[n - 1][2], dp[n - 1][4]);
        return maxProfit;
    }
}

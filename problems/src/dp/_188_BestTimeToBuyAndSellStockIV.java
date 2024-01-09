
package dp;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/

public class _188_BestTimeToBuyAndSellStockIV {

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][k + 1][2];
        int maxProfit = 0;
        // no transactions at all
        dp[0][0][0] = 0;
        dp[0][0][1] = 0;

        // 1-k transactions at day 1
        for (int j = 1; j <= k; j++) {
            dp[0][j][0] = -prices[0];
            dp[0][j][1] = 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][1] - prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j][0] + prices[i]);
                maxProfit = Math.max(maxProfit, dp[i][j][1]);
            }
        }
        return maxProfit;
    }
}

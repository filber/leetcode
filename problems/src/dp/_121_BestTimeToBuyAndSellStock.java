package dp;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class _121_BestTimeToBuyAndSellStock {

    public static int maxProfitDP(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int maxProfit = 0;
        int[] dp = new int[prices.length];
        dp[0] = prices[0];

        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - dp[i - 1]);
            dp[i] = Math.min(dp[i - 1], prices[i]);
        }

        return maxProfit;
    }


    public static int maxProfitDPImproved(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int buy = Integer.MIN_VALUE;
        int sell = 0;
        for (int i = 0; i < prices.length; i++) {
            buy = Math.max(buy, -prices[i]);
            sell = Math.max(sell, buy + prices[i]);
        }

        return sell;
    }

    public static void main(String[] args) {
        // 5
        int m1 = maxProfitDPImproved(new int[]{7, 1, 5, 3, 6, 4});
        // 0
        int m2 = maxProfitDPImproved(new int[]{7, 6, 4, 3, 1});

    }
}

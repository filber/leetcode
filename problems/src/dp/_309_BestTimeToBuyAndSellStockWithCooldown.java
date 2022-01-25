package dp;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
public class _309_BestTimeToBuyAndSellStockWithCooldown {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }

        int[] buy = new int[n];
        buy[0] = -prices[0];
        int[] sell = new int[n];
        int[] cool = new int[n];
        for (int i = 1; i < n; i++) {
            sell[i] = buy[i - 1] + prices[i];
            cool[i] = Math.max(sell[i - 1], cool[i - 1]);
            buy[i] = Math.max(cool[i - 1] - prices[i], buy[i - 1]);
        }

        return Math.max(sell[n - 1], cool[n - 1]);
    }

    public static void main(String[] args) {
        int m1 = maxProfit(new int[]{1, 2, 3, 0, 2});
        int m2 = maxProfit(new int[]{1});
    }
}

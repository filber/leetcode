package dp;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/

public class _309_BestTimeToBuyAndSellStockWithCooldown {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] hold = new int[n];
        int[] notHold = new int[n];
        int[] cooldown = new int[n];

        hold[0] = -prices[0];
        notHold[0] = 0;
        cooldown[0] = 0;

        for (int i = 1; i < n; i++) {
            hold[i] = Math.max(hold[i - 1], cooldown[i - 1] - prices[i]);
            notHold[i] = hold[i - 1] + prices[i];
            cooldown[i] = Math.max(cooldown[i - 1], notHold[i - 1]);
        }

        int maxProfit = Math.max(notHold[n - 1], cooldown[n - 1]);
        return maxProfit;
    }
}

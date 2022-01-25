package dp;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
public class _122_BestTimeToBuyAndSellStockII {
    public static int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        int buy = -prices[0];
        int sell = 0;
        for (int i = 1; i < prices.length; i++) {
            int preBuy = buy;
            buy = Math.max(buy, sell - prices[i]);
            sell = Math.max(sell, preBuy + prices[i]);
        }

        return sell;
    }

    public static void main(String[] args) {
        int m1 = maxProfit(new int[]{7, 1, 5, 3, 6, 4}); // 5-1 + 6-3 = 7
        int m2 = maxProfit(new int[]{1, 2, 3, 4, 5}); // 4
        int m3 = maxProfit(new int[]{7, 6, 4, 3, 1}); // 0
    }
}

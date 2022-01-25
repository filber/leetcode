package dp;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
public class _714_BestTimeToBuyAndSellStockWithTransactionFee {
    public static int maxProfit(int[] prices, int fee) {
        if (prices.length==1) {
            return 0;
        }

        int buy = -prices[0];
        int sell = 0;
        for (int i = 1; i < prices.length; i++) {
            int preBuy = buy;
            buy = Math.max(buy, sell - prices[i]);
            sell = Math.max(sell, preBuy + prices[i] - fee);
        }

        return sell;
    }

    public static void main(String[] args) {
        int m1 = maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2);
        int m2 = maxProfit(new int[]{1, 3, 7, 5, 10, 3}, 3);
    }
}

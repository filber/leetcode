package dp;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
public class _714_BestTimeToBuyAndSellStockWithTransactionFee {
    public static int maxProfit(int[] prices, int fee) {
        if (prices.length==1) {
            return 0;
        }

        int hold = -prices[0];
        int notHold = 0;
        for (int i = 1; i < prices.length; i++) {
//            hold[i] = Math.max(hold[i - 1], notHold[i - 1] - prices[i]);
//            notHold[i] = Math.max(notHold[i - 1], hold[i - 1] + prices[i] - fee);
            int preHold = hold;
            hold = Math.max(hold, notHold - prices[i]);
            notHold = Math.max(notHold, preHold + prices[i] - fee);
        }

        return notHold;
    }

    public static void main(String[] args) {
        int m1 = maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2);
        int m2 = maxProfit(new int[]{1, 3, 7, 5, 10, 3}, 3);
    }
}

package dp;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class _121_BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int min = Integer.MAX_VALUE;
        int profit = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i] - min);
        }
        return profit;
    }

    public static void main(String[] args) {
        // 5
        int m1 = maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        // 0
        int m2 = maxProfit(new int[]{7, 6, 4, 3, 1});
        // 0
        int m3 = maxProfit(new int[]{1});
    }
}

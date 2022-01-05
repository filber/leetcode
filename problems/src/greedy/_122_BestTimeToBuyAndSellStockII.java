package greedy;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
//[Greedy]
public class _122_BestTimeToBuyAndSellStockII {
    public static int maxProfit(int[] prices) {
        int profit = 0;
        int cost = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i]+cost>0) {
                // sell stock
                profit += prices[i]+cost;
            }
            // buy stock
            cost = - prices[i];
        }

        return profit;
    }

    public static void main(String[] args) {
        int m1 = maxProfit(new int[]{7, 1, 5, 3, 6, 4}); // 5-1 + 6-3 = 7
        int m2 = maxProfit(new int[]{1,2,3,4,5}); // 4
        int m3 = maxProfit(new int[]{7,6,4,3,1}); // 0
    }
}

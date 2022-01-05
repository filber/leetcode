//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
package dp;
import java.util.Arrays;

public class _188_BestTimeToBuyAndSellStockIV {
    public static int maxProfit(int k, int[] prices) {
        if (k==0 || prices.length==0) {
            return 0;
        }

        int[] cost = new int[k + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        int[] profit = new int[k + 1];

        for (int i = 0; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                cost[j] = Math.min(cost[j], prices[i] - profit[j - 1]);
                profit[j] = Math.max(profit[j], prices[i] - cost[j]);
            }
        }

        return profit[k];
    }

    public static void main(String[] args) {
        int m1 = maxProfit(2, new int[]{3, 3, 5, 0, 0, 3, 1, 4}); // 6
        int m2 = maxProfit(2, new int[]{1, 2, 3, 4, 5}); //4
        int m3 = maxProfit(2, new int[]{7, 6, 4, 3, 1}); //0
        int m4 = maxProfit(2, new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0}); //13
        int m5 = maxProfit(2, new int[]{2, 4, 1}); //2
        int m6 = maxProfit(2, new int[]{3,2,6,5,0,3}); //7

    }
}

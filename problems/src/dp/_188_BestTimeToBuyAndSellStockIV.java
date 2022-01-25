
package dp;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/

import java.util.Arrays;
public class _188_BestTimeToBuyAndSellStockIV {
    public static int maxProfit(int k, int[] prices) {
        if (k == 0 || prices.length < 2) {
            return 0;
        }

        int[] buy = new int[k + 1];
        Arrays.fill(buy, Integer.MIN_VALUE);
        int[] sell = new int[k + 1];

        for (int p : prices) {
            for (int i = 1; i <= k; i++) {
                buy[i] = Math.max(buy[i], sell[i - 1] - p);
                sell[i] = Math.max(sell[i], buy[i] + p);
            }
        }

        return sell[k];
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

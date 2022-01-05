package dp;//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/

//[Dynamic Programming]
public class _123_BestTimeToBuyAndSellStockIII {

    public static int maxProfit(int[] prices) {
        int t1Cost = Integer.MAX_VALUE;
        int t2Cost = Integer.MAX_VALUE;
        int t1Profit = 0;
        int t2Profit = 0;

        for (int price : prices) {
            t1Cost = Math.min(t1Cost, price);
            t1Profit = Math.max(t1Profit, price - t1Cost);
            t2Cost = Math.min(t2Cost, price - t1Profit);
            t2Profit = Math.max(t2Profit, price - t2Cost);
        }

        return t2Profit;
    }

    public static int maxProfitDP(int[] prices) {
        int n = prices.length;
        // forward
        int[] fDP = new int[n];
        int fMin = prices[0];
        fDP[0] = 0;
        for (int i = 1; i < n; i++) {
            fMin = Math.min(fMin, prices[i]);
            fDP[i] = Math.max(prices[i] - fMin, fDP[i - 1]);
        }

        // backward
        int[] bDP = new int[n];
        int bMax = prices[n-1];
        bDP[n-1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            bMax = Math.max(bMax, prices[i]);
            bDP[i] = Math.max(bMax - prices[i], bDP[i + 1]);
        }

        int maxP = 0;
        for (int i = 0; i < n; i++) {
            maxP = Math.max(maxP, fDP[i] + bDP[i]);
        }

        return maxP;
    }

    public static void main(String[] args) {
        int m1 = maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}); // 6
        int m2 = maxProfit(new int[]{1, 2, 3, 4, 5}); //4
        int m3 = maxProfit(new int[]{7, 6, 4, 3, 1}); //0
        int m4 = maxProfit(new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0}); //13
    }
}

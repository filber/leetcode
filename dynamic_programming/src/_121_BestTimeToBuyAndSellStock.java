public class _121_BestTimeToBuyAndSellStock {

    public static int maxProfitDP(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int maxProfit = 0;
        int[] dp = new int[prices.length];
        dp[0] = prices[0];

        for (int i = 1; i < prices.length; i++) {
          maxProfit = Math.max(maxProfit, prices[i] - dp[i-1]);
          dp[i] = Math.min(dp[i-1],prices[i]);
        }

        return maxProfit;
    }


    public int maxProfitDPImproved(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i - 1]);
            max = Math.max(max, prices[i] - min);
        }

        return max;
    }

    public static void main(String[] args) {
        _121_BestTimeToBuyAndSellStock instance = new _121_BestTimeToBuyAndSellStock();

        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        int maxProfit = maxProfitDP(prices);
        System.out.println(maxProfit);
    }
}

public class _121_BestTimeToBuyAndSellStock {

  // Bad, O(n^2)
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length < 2) {
      return 0;
    }

    int profit = 0;
    for (int start = 0; start < prices.length; start++) {
      for (int end = start + 1; end < prices.length; end++) {
        profit = Math.max(profit, prices[end] - prices[start]);
      }
    }

    return profit;
  }

  public int maxProfitDP(int[] prices) {
    if (prices == null || prices.length < 2) {
      return 0;
    }

    int[] lowest = new int[prices.length];
    int p = prices[0];
    for (int i = 0; i < prices.length; i++) {
      p = Math.min(p,prices[i]);
      lowest[i] = p;
    }

    int maxProfit = 0;
    for (int i = 1; i < prices.length; i++) {
      int previousLowest = lowest[i - 1];
      maxProfit = Math.max(maxProfit, prices[i] - previousLowest);
    }

    return maxProfit;
  }

  public int maxProfitDPImproved(int[] prices) {
    if (prices == null || prices.length < 2) {
      return 0;
    }

    int min=Integer.MAX_VALUE;
    int max = 0;
    for (int i = 1; i < prices.length; i++) {
      min = Math.min(min, prices[i - 1]);
      max = Math.max(max,prices[i] - min);
    }

    return max;
  }

  public static void main(String[] args) {
    _121_BestTimeToBuyAndSellStock instance = new _121_BestTimeToBuyAndSellStock();

    int[] prices = new int[] {7, 1, 5, 3, 6, 4};
    int maxProfit = instance.maxProfitDPImproved(prices);
    assert maxProfit == 5;
  }
}

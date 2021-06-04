public class _123_BestTimeToBuyAndSellStockIII {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int min_1 = Integer.MIN_VALUE;
        int max_1 = 0;
        int min_2 = Integer.MIN_VALUE;
        int max_2 = 0;
        for(int p : prices) {
            min_1 = Math.max(min_1, -p);
            max_1 = Math.max(max_1, min_1 + p);
            min_2 = Math.max(min_2, max_1 - p);
            max_2 = Math.max(max_2, min_2 + p);
        }
        return max_2;
    }

    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int result = maxProfit(prices);
        System.out.println(result);
    }
}

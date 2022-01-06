package greedy;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
//[Greedy]
public class _122_BestTimeToBuyAndSellStockII {
    public static int maxProfit(int[] prices) {
        if (prices.length==1) {
            return 0;
        }
        int hold = - prices[0];
        int notHold = 0;
        for (int i = 1; i < prices.length; i++) {
//            hold[i] = Math.max(hold[i-1],notHold[i-1]-prices[i]);
//            notHold[i] = Math.max(notHold[i - 1], hold[i - 1] + prices[i]);
            int preHold = hold;
            hold = Math.max(hold, notHold - prices[i]);
            notHold = Math.max(notHold, preHold + prices[i]);
        }

        return notHold;
    }

    public static void main(String[] args) {
        int m1 = maxProfit(new int[]{7, 1, 5, 3, 6, 4}); // 5-1 + 6-3 = 7
        int m2 = maxProfit(new int[]{1,2,3,4,5}); // 4
        int m3 = maxProfit(new int[]{7,6,4,3,1}); // 0
    }
}

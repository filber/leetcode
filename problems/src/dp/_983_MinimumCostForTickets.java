package dp;

// https://leetcode.com/problems/minimum-cost-for-tickets/
public class _983_MinimumCostForTickets {

//  Constraint:
//  1 <= days.length <= 365
//  1 <= days[i] <= 365
//  days is in strictly increasing order.
//  costs.length == 3
//  1 <= costs[i] <= 1000

    public static int mincostTickets(int[] days, int[] costs) {
        int start = days[0];
        int end = days[days.length - 1];
        int[] dp = new int[end - start + 2];
        int j = 0; // j point to days
        // i point to dp
        for (int i = 1; i < dp.length; i++) {
            if (i - 1 + start == days[j]) {
                int oneDay = dp[i - 1] + costs[0];
                int oneWeek = (i <= 7 ? 0 : dp[i - 7]) + costs[1];
                int oneMonth = (i <= 30 ? 0 : dp[i - 30]) + costs[2];
                dp[i] = Math.min(oneDay, Math.min(oneWeek, oneMonth));
                j++;
            } else {
                dp[i] = dp[i - 1];
            }
        }

        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        // 11 (2+7+2)
        int m1 = mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15});

        // 17 (15+2)
        int m2 = mincostTickets(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31}, new int[]{2, 7, 15});

        // 16
        int m3 = mincostTickets(new int[]{6, 8, 9, 18, 20, 21, 23, 25}, new int[]{2, 10, 41});
    }
}

package dp;

// https://leetcode.com/problems/minimum-cost-for-tickets/
public class _983_MinimumCostForTickets {

    public int mincostTickets(int[] days, int[] costs) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int[] dp = new int[366];
        for (int day : days) {
            min = Math.min(min, day);
            max = Math.max(max, day);
            dp[day] = -1;
        }

        for (int i = min; i <= max; i++) {
            if (dp[i] != -1) {
                dp[i] = dp[i - 1]; // don't need to travel at ith day
            } else {
                int prev1 = i - 1;
                int prev7 = Math.max(0, i - 7);
                int prev30 = Math.max(0, i - 30);
                dp[i] = Math.min(dp[prev1] + costs[0], Math.min(dp[prev7] + costs[1], dp[prev30] + costs[2]));
            }
        }
        return dp[max];
    }
}

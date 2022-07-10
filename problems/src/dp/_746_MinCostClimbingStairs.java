package dp;

// https://leetcode.com/problems/min-cost-climbing-stairs/

public class _746_MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int prev = cost[0];
        int cur = cost[1];
        for (int i = 2; i < n; i++) {
            int min = Math.min(prev, cur) + cost[i];
            prev = cur;
            cur = min;
        }

        return Math.min(prev, cur);
    }
}

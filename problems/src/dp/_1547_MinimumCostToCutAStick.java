package dp;

//https://leetcode.com/problems/minimum-cost-to-cut-a-stick/

import java.util.Arrays;

public class _1547_MinimumCostToCutAStick {

    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int m = cuts.length + 1;
        int[] sticks = new int[m];
        sticks[0] = cuts[0];
        for (int i = 1; i < m - 1; i++) {
            sticks[i] = cuts[i] - cuts[i - 1];
        }
        sticks[m - 1] = n - cuts[m - 2];

        int[] prefixSum = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            prefixSum[i] = prefixSum[i - 1] + sticks[i - 1];
        }

        int[][] dp = new int[m][m];
        // init len = 2
        for (int i = 0; i < m - 1; i++) {
            dp[i][i + 1] = sticks[i] + sticks[i + 1];
        }

        for (int len = 3; len <= m; len++) {
            for (int i = 0; i + len - 1 < m; i++) {
                int j = i + len - 1;
                int totalCost = prefixSum[j + 1] - prefixSum[i];
                int minCost = Integer.MAX_VALUE;
                // PAY ATTENTION! i<=k<j, k starts from i
                for (int k = i; k < j; k++) {
                    minCost = Math.min(minCost, dp[i][k] + dp[k + 1][j]);
                }
                dp[i][j] = minCost + totalCost;
            }
        }

        return dp[0][m - 1];
    }
}

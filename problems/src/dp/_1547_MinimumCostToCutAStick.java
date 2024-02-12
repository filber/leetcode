package dp;

//https://leetcode.com/problems/minimum-cost-to-cut-a-stick/

import java.util.Arrays;

public class _1547_MinimumCostToCutAStick {

    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[] sticks = new int[cuts.length+1];
        sticks[0] = cuts[0];
        for(int i=1;i<sticks.length-1;i++) {
            sticks[i] = cuts[i] - cuts[i-1];
        }
        sticks[sticks.length-1] = n - cuts[cuts.length-1];

        int[] prefixSum = new int[sticks.length+1];
        prefixSum[0] = 0;
        for(int i = 1;i<prefixSum.length;i++) {
            prefixSum[i] = prefixSum[i-1] + sticks[i-1];
        }

        int[][] dp = new int[sticks.length][sticks.length];
        for(int len=2;len<=sticks.length;len++) {
            for (int i = 0, j = len - 1; j < sticks.length; i++, j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k + 1 <= j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + prefixSum[j + 1] - prefixSum[i]);
                }
            }
        }
        return dp[0][sticks.length-1];
    }
}

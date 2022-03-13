package dp;

//https://leetcode.com/problems/minimum-cost-to-cut-a-stick/

import java.util.Arrays;

public class _1547_MinimumCostToCutAStick {

    public int minCost(int n, int[] cuts) {
        int m = cuts.length + 1;
        Arrays.sort(cuts);
        int[] units = new int[m];
        int pre = 0;
        for (int i = 0; i < cuts.length; i++) {
            units[i] = cuts[i] - pre;
            pre = cuts[i];
        }
        units[m - 1] = n - pre;

        int[] prefix = new int[m+1];
        for (int i = 1; i <= m; i++) {
            prefix[i] = prefix[i - 1] + units[i - 1];
        }

        int[][] dp = new int[m][m];

        for (int i = 0; i + 1 < m; i++) {
            dp[i][i+1] = units[i] + units[i+1];
        }

        for (int len = 3; len <= m; len++) {
            for (int i = 0; i + len <= m; i++) {
                int j = i + len - 1;
                int min = Integer.MAX_VALUE;
                int stickLen = prefix[j + 1] - prefix[i];
                for (int k = i; k < j; k++) {
                    min = Math.min(min, dp[i][k] + dp[k + 1][j]);
                }
                dp[i][j] = min + stickLen;
            }
        }

        return dp[0][m - 1];
    }
}

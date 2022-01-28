package dp;

//https://leetcode.com/problems/minimum-cost-to-cut-a-stick/

import java.util.Arrays;

public class _1547_MinimumCostToCutAStick {

    public static int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[] c = new int[cuts.length + 2];
        int m = c.length;
        c[0] = 0;
        for (int i = 1; i < m - 1; i++) {
            c[i] = cuts[i - 1];
        }
        c[m - 1] = n;

        int[][] dp = new int[m][m];
        for (int i = 0; i < m; i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        for (int i = 0; i < m - 1; i++)
            dp[i][i + 1] = 0;

        for (int len = 2; len < m; len++) {
            for (int i = 0; i < m - len; i++) {
                int j = i + len;
                int cost = c[j] - c[i];
                int min = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    min = Math.min(min, dp[i][k] + dp[k][j]);
                }
                dp[i][j] = min + cost;
            }
        }
        return dp[0][m - 1];
    }

    public static void main(String[] args) {
        int c1 = minCost(7, new int[]{1, 3, 4, 5}); // 16
        int c2 = minCost(9, new int[]{5, 6, 1, 4, 2}); // 22
        int c6 = minCost(10, new int[]{7, 8, 9, 2, 1}); // 24
        int c3 = minCost(2, new int[]{1}); // 2
        int c4 = minCost(3, new int[]{1}); // 3
        int c5 = minCost(3, new int[]{1, 2}); // 5
    }
}

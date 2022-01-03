package dp;
//https://leetcode.com/problems/minimum-cost-to-cut-a-stick/
//1547. Minimum Cost to Cut a Stick
import java.util.Arrays;

public class _1547_MinimumCostToCutAStick {
    public static int minCost(int n, int[] cuts) {
        int[] sortedCuts = new int[cuts.length + 2];
        sortedCuts[0] = 0;
        sortedCuts[sortedCuts.length-1] = n;
        for (int i = 0; i < cuts.length; i++) {
            sortedCuts[i + 1] = cuts[i];
        }
        Arrays.sort(sortedCuts);
        int m = sortedCuts.length;

        int[][] dp = new int[m][m];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < sortedCuts.length - 1; i++) {
            dp[i][i+1] = 0;
        }

        return dfs(dp, sortedCuts, 0, m - 1);
    }

    public static int dfs(int[][] dp, int[] cuts, int i, int j) {
        if (dp[i][j] < Integer.MAX_VALUE) {
            return dp[i][j]; // already solved
        }
        for (int k = i+1; k < j; k++) {
            int len = cuts[j] - cuts[i];
            int leftCost = dfs(dp, cuts, i, k);
            int rightCost = dfs(dp, cuts, k, j);
            int cost = leftCost + rightCost + len;
            dp[i][j] = Math.min(dp[i][j], cost);
        }
        return dp[i][j];
    }

    public static void main(String[] args) {
        int c1 = minCost(7, new int[]{1, 3, 4, 5}); // 16
        int c2 = minCost(9, new int[]{5, 6, 1, 4, 2}); // 22

        int c3 = minCost(2, new int[]{1}); // 2
        int c4 = minCost(3, new int[]{1}); // 3
        int c5 = minCost(3, new int[]{1,2}); // 5
    }
}

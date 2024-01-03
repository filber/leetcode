package dp;

//https://leetcode.com/problems/longest-common-subsequence/

public class _1143_LongestCommonSubsequence {

    public int longestCommonSubsequence(String p, String q) {
        char[] P = p.toCharArray();
        int m = P.length;
        char[] Q = q.toCharArray();
        int n = Q.length;

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (P[i - 1] == Q[j - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, Math.max(dp[i - 1][j], dp[i][j - 1]));
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }
}

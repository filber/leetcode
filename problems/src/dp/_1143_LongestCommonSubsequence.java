package dp;

//https://leetcode.com/problems/longest-common-subsequence/

public class _1143_LongestCommonSubsequence {

    public int longestCommonSubsequence(String A, String B) {
        char[] aChars = A.toCharArray();
        int m = aChars.length;
        char[] bChars = B.toCharArray();
        int n = bChars.length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            char a = aChars[i - 1];
            for (int j = 1; j <= n; j++) {
                char b = bChars[j - 1];
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (a == b) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[m][n];
    }
}

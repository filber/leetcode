package dp;

//https://leetcode.com/problems/longest-common-subsequence/

public class _1143_LongestCommonSubsequence {

    public int longestCommonSubsequence(String A, String B) {
        char[] aChars = A.toCharArray();
        char[] bChars = B.toCharArray();
        int m = aChars.length;
        int n = bChars.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char aCh = aChars[i - 1];
            for (int j = 1; j <= n; j++) {
                char bCh = bChars[j - 1];
                int lcs = 0;
                if (aCh == bCh) {
                    lcs = dp[i - 1][j - 1] + 1;
                }
                lcs = Math.max(lcs, dp[i][j - 1]);
                lcs = Math.max(lcs, dp[i - 1][j]);
                dp[i][j] = lcs;
            }
        }

        return dp[m][n];
    }
}

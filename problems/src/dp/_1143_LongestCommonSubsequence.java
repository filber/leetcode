package dp;

//https://leetcode.com/problems/longest-common-subsequence/

public class _1143_LongestCommonSubsequence {

    public int longestCommonSubsequence(String A, String B) {
        char[] AChars = A.toCharArray();
        char[] BChars = B.toCharArray();
        int m = AChars.length;
        int n = BChars.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char a = AChars[i - 1];
            for (int j = 1; j <= n; j++) {
                int len = 0;
                char b = BChars[j - 1];
                if (a == b) {
                    len = dp[i - 1][j - 1] + 1;
                }
                len = Math.max(len, dp[i - 1][j]);
                len = Math.max(len, dp[i][j - 1]);
                dp[i][j] = len;
            }
        }

        return dp[m][n];
    }
}

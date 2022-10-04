package dp;

//https://leetcode.com/problems/edit-distance/

public class _72_EditDistance {

    public int minDistance(String word1, String word2) {
        char[] A = word1.toCharArray();
        int m = A.length;
        char[] B = word2.toCharArray();
        int n = B.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            char a = A[i - 1];
            for (int j = 1; j <= n; j++) {
                char b = B[j - 1];
                if (a == b) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }

        return dp[m][n];
    }
}

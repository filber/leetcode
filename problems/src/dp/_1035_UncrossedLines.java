package dp;

//https://leetcode.com/problems/uncrossed-lines/

public class _1035_UncrossedLines {

    public int maxUncrossedLines(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            int a = A[i - 1];
            for (int j = 1; j <= n; j++) {
                int b = B[j - 1];
                if (a == b) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}

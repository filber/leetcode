package dp;

public class _583_Delete_Operation_For_Two_Strings {

    public int minDistance(String AStr, String BStr) {
        char[] A = AStr.toCharArray();
        int m = A.length;
        char[] B = BStr.toCharArray();
        int n = B.length;
        int[][] dp = new int[m + 1][n + 1];
        // dp[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            char a = A[i - 1];
            for (int j = 1; j <= n; j++) {
                char b = B[j - 1];
                if (a == b) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + 2);
                }
            }
        }

        return dp[m][n];
    }
}

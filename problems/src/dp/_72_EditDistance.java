package dp;

//https://leetcode.com/problems/edit-distance/

public class _72_EditDistance {

    public int minDistance(String a, String b) {
        char[] A = a.toCharArray();
        char[] B = b.toCharArray();
        int m = A.length;
        int n = B.length;

        // minimum steps needed to reshape A[0..i] into B[0..j]
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0; // empty -> empty
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i; // A[0..i] -> empty, delete all chars
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j; // empty -> B[0..j], insert all chars
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1]; // no need for extra steps
                } else {
                    dp[i][j] = Math.min(
                            dp[i - 1][j - 1] + 1, // A[i] -> B[j]
                            Math.min(dp[i - 1][j] + 1, // delete A[i]
                                    dp[i][j - 1] + 1)  // insert B[j]
                    );
                }
            }
        }
        return dp[m][n];
    }
}

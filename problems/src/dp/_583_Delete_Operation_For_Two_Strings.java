package dp;

//https://leetcode.com/problems/delete-operation-for-two-strings/

public class _583_Delete_Operation_For_Two_Strings {

    public int minDistance(String a, String b) {
        char[] A = a.toCharArray();
        char[] B = b.toCharArray();
        int m = A.length;
        int n = B.length;

        // dp[i][j] is the longest common subsequence of A[0..i] and B[0..j]
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, Math.max(dp[i - 1][j], dp[i][j - 1]));
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // total deletions of both A and B
        int result = m - dp[m][n] + n - dp[m][n];
        return result;
    }
}

package dp;

//https://leetcode.com/problems/maximum-length-of-repeated-subarray/

public class _718_MaximumLengthOfRepeatedSubarray {

    public int findLength(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int[][] dp = new int[m + 1][n + 1];
        int len = 0;
        for (int i = 1; i <= m; i++) {
            int a = A[i - 1];
            for (int j = 1; j <= n; j++) {
                int b = B[j - 1];
                if (a == b) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    len = Math.max(len, dp[i][j]);
                }
//                else {
//                    dp[i][j] = 0;
//                }
            }
        }
        return len;
    }
}

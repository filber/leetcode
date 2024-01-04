package dp;

//https://leetcode.com/problems/maximum-length-of-repeated-subarray/

public class _718_MaximumLengthOfRepeatedSubarray {

    public int findLength(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int[][] dp = new int[m + 1][n + 1];
        int result = Integer.MIN_VALUE;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }
}

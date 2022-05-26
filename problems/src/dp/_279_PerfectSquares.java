package dp;

//https://leetcode.com/problems/perfect-squares/

public class _279_PerfectSquares {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                int squares = j * j;
                min = Math.min(min, dp[i - squares]);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }
}

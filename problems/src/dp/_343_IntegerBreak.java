package dp;

//https://leetcode.com/problems/integer-break/

public class _343_IntegerBreak {

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int max = 1;
            for (int j = i - 1; j >= 1; j--) {
                int residual = i - j;
                max = Math.max(max, Math.max(residual * j, residual * dp[j]));
            }
            dp[i] = max;
        }
        return dp[n];
    }
}

package dp;

//https://leetcode.com/problems/k-inverse-pairs-array/

public class _629_KInversePairsArray {

    public int kInversePairs(int n, int k) {
        if (k > n * (n - 1) / 2)
            return 0;
        if (k == 0 || k == n * (n - 1) / 2)
            return 1;
        long[][] dp = new long[n + 1][k + 1];
        int mod = 1000000007;
        dp[2][0] = 1;
        dp[2][1] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                if (j >= i)
                    dp[i][j] -= dp[i - 1][j - i];
                dp[i][j] = (dp[i][j] + mod) % mod;
            }
        }
        return (int) dp[n][k];
    }
}

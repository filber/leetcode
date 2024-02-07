package dp;

//https://leetcode.com/problems/coin-change/

import java.util.Arrays;

public class _322_CoinChange {

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[amount + 1][n + 1];

        for (int i = 0; i <= amount; i++) {
            Arrays.fill(dp[i], amount + 1);
        }
        // init
        dp[0][0] = 0;
        for (int j = 1; j <= n; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= amount; i++) {
            for (int j = 1; j <= n; j++) {
                int v = coins[j - 1];
                if (i >= v) {
                    dp[i][j] = Math.min(dp[i - v][j] + 1, dp[i][j - 1]);
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        if (dp[amount][n] > amount) {
            return -1;
        }
        return dp[amount][n];
    }
}

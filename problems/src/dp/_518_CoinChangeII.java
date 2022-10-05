package dp;

import java.util.Arrays;

// https://leetcode.com/problems/coin-change-2/

public class _518_CoinChangeII {

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int v : coins) {
            for (int i = v; i <= amount; i++) {
                dp[i] = dp[i] + dp[i - v];
            }
        }
        return dp[amount];
    }

    public int change2D(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j <= amount; j++) {
            if (j % coins[0] == 0) {
                dp[0][j] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            int v = coins[i];
            for (int j = 0; j <= amount; j++) {
                if (j >= v) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - v];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][amount];
    }
}

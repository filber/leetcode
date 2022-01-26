package dp;

import java.util.Arrays;

// https://leetcode.com/problems/coin-change-2/
public class _518_CoinChangeII {
    public static int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            int coin = coins[i];
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }
        return dp[amount];
    }

    public static int change2D(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[amount + 1][n + 1];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i <= amount; i++) {
            for (int j = 1; j <= n; j++) {
                int coin = coins[j-1];
                if (i - coin >= 0) {
                    dp[i][j] = dp[i][j - 1] + dp[i - coin][j];
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[amount][n];
    }

    public static void main(String[] args) {
        // 4 : [5],[1*5],[1*3+2],[1+2*2]
        int w1 = change(5, new int[]{1, 2, 5}); // 4
        int w2 = change(3, new int[]{2}); // 0
        int w3 = change(10, new int[]{10}); // 1
        int w4 = change(5, new int[]{1, 2, 3, 5}); // 6
    }

}

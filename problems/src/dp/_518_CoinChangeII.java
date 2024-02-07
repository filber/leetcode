package dp;

// https://leetcode.com/problems/coin-change-2/

public class _518_CoinChangeII {

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[amount+1][n+1];
        // init
        // dp[i][0] = 0;
        for(int j=0;j<=n;j++) {
            dp[0][j] = 1;
        }
        // iterate
        for(int i=1;i<=amount;i++) {
            for(int j=1;j<=n;j++) {
                int v = coins[j-1];
                if(i>=v) {
                    dp[i][j] = dp[i-v][j] + dp[i][j-1];
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        return dp[amount][n];
    }

}

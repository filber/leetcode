package dp;

// https://leetcode.com/problems/coin-change-2/
public class _518_CoinChangeII {
    public static int change1D(int amount, int[] coins) {
        if (amount==0) {
            return 1; // not put any coins
        }

        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount ; j++) {
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }

        return dp[amount];
    }

    public static int change(int amount, int[] coins) {
        if (amount==0) {
            return 1; // not put any coins
        }

        int n = coins.length;
        int[][] dp = new int[n+1][amount + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= coins.length ; i++) {
        for (int amt = 1; amt <= amount; amt++) {

                int c = coins[i - 1];
                if (amt>= c) {
                    // not use i + use i
                    dp[i][amt] = dp[i-1][amt] + dp[i][amt-c];
                } else {
                    // not use i
                    dp[i][amt] = dp[i - 1][amt];
                }
            }
        }

        return dp[n][amount];
    }

    public static void main(String[] args) {
        int w1 = change(5, new int[]{1, 2, 5}); // 4
        int w2 = change(3, new int[]{2}); // 0
        int w3 = change(10, new int[]{10}); // 1
        int w4 = change(5, new int[]{1, 2, 3, 5}); // 6
    }

}

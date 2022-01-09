package dp;

//https://leetcode.com/problems/coin-change/

public class _322_CoinChange {
    // Constraints:
    // 1 <= coins.length <= 12
    // 1 <= coins[i] <= 2^31 - 1
    // 0 <= amount <= 10^4
    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
//        int n = coins.length;
//        int[] dp = new int[amount + 1];
//        for (int i = 0; i < n; i++) {
//            for (int j = 1; j <= amount; j++) {
//                int w = coins[i];
//                int v = coins[i];
//                int notPut = dp[j];
//                int put = 0;
//                if (j >= w) {
//                    put = dp[j - w] + v;
//                }
//                dp[j] = Math.max(notPut, put);
//            }
//        }
//        if (dp[amount] != amount) {
//            return -1;
//        }

//        return dp[amount];
        int[] dp = new int[10001];
        int cnt = dfs(coins, dp, amount);
        if (cnt>100000) {
            return -1;
        } else {
            return cnt;
        }
    }

    private static int dfs(int[] coins, int[] dp, int amount) {
        if (amount == 0) {
            return 0;
        } else if (amount<0) {
            return 100000;
        }
        else if (dp[amount]!=0) {
            return dp[amount];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int needExtra = dfs(coins, dp, amount - coins[i]);
            min = Math.min(min, needExtra + 1);
        }

        dp[amount] = min;
        return min;
    }

    public static void main(String[] args) {
        int c1 = coinChange(new int[]{1, 2, 5}, 11);
        int c2 = coinChange(new int[]{2}, 3);
        int c3 = coinChange(new int[]{1}, 0);
    }
}

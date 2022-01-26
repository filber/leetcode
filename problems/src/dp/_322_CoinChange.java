package dp;

//https://leetcode.com/problems/coin-change/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _322_CoinChange {
    // Constraints:
    // 1 <= coins.length <= 12
    // 1 <= coins[i] <= 2^31 - 1
    // 0 <= amount <= 10^4

    public static int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[amount + 1][n + 1];
        Arrays.fill(dp[0], 0);
        for (int i = 1; i <= amount; i++) {
            Arrays.fill(dp[i], amount + 1);
        }

        for (int i = 1; i <= amount; i++) {
            for (int j = 1; j <= coins.length; j++) {
                int coin = coins[j - 1];
                if (i - coin >= 0) {
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i - coin][j] + 1);
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        if (dp[amount][n] > amount) {
            return -1;
        } else {
            return dp[amount][n];
        }
    }

    public static int coinChange1D(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                int coin = coins[j];
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        if (dp[amount] > amount) {
            return -1;
        } else {
            return dp[amount];
        }
    }

    public static int coinChangeDFS(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        Map<Integer, Integer> mem = new HashMap<>();
        int cnt = dfs(coins, mem, amount);
        if (cnt > 100000) {
            return -1;
        } else {
            return cnt;
        }
    }

    private static int dfs(int[] coins, Map<Integer, Integer> mem, int amount) {
        if (amount == 0) {
            return 0;
        } else if (mem.containsKey(amount)) {
            return mem.get(amount);
        }

        // Max Amount + 1
        int min = 100001;
        for (int i = 0; i < coins.length; i++) {
            if (amount - coins[i] >= 0) {
                int needExtra = dfs(coins, mem, amount - coins[i]);
                min = Math.min(min, needExtra + 1);
            }
        }

        mem.put(amount, min);
        return min;
    }

    public static void main(String[] args) {
        // 3 [11=5+5+1]
        int c1 = coinChange(new int[]{1, 2, 5}, 11);
        // -1
        int c2 = coinChange(new int[]{2}, 3);
        // 0
        int c3 = coinChange(new int[]{1}, 0);
        // 20
        int c4 = coinChange(new int[]{186, 419, 83, 408}, 6249);
    }
}

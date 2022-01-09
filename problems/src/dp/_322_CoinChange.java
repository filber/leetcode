package dp;

//https://leetcode.com/problems/coin-change/

import java.util.Arrays;

public class _322_CoinChange {
    // Constraints:
    // 1 <= coins.length <= 12
    // 1 <= coins[i] <= 2^31 - 1
    // 0 <= amount <= 10^4

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        int[] amtDP = new int[amount + 1];
        Arrays.fill(amtDP,-amount);
        amtDP[0] = 0;
        int[] cntDP = new int[amount + 1];
        Arrays.fill(cntDP,amount);
        cntDP[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                int coin = coins[j];
                if (i >= coin) {
                    cntDP[i] = Math.min(cntDP[i], cntDP[i - coin] + 1);
                }

                int put = 0;
                if (i >= coin) {
                    put = amtDP[i - coin] + coin;
                }
                amtDP[i] = Math.max(amtDP[i], put);
            }
        }

        if (amtDP[amount] == amount) {
            return cntDP[amount];
        } else {
            return -1;
        }
    }

    public static int coinChangeDFS(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

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
        int c4 = coinChange(new int[]{186,419,83,408}, 6249);
    }
}

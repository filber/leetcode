package dp;

//https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/

public class _1155_NumberOfDiceRollsWithTargetSum {

    private static final int modulo = (int) (1e9 + 7);
    public int numRollsToTarget(int n, int K, int target) {
        // 1. Guard condition
        if (n * K < target) {
            return 0; // not possible
        } else if (n * K == target) {
            return 1; // one way
        }

        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                for (int k = 1; k <= K && k <= j; k++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % modulo;
                }
            }
        }

        return dp[n][target];
    }
}

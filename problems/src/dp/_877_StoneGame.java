package dp;

// https://leetcode.com/problems/stone-game/

public class _877_StoneGame {

    public boolean stoneGame(int[] piles) {
        int n = piles.length;

        // dp[i][j] relative score Alice can win from i to j
        int[][] dp = new int[n][n];

        // init diagonal with stones
        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n; i++) {
                int j = len - 1 + i;
                if (j >= n) {
                    break;
                }

                dp[i][j] = Math.max(
                        piles[i] - dp[i + 1][j], // pick the most left one - i
                        piles[j] - dp[i][j - 1]  // pick the most right one - j
                );
            }
        }

        // Alice has a positive relative score
        return dp[0][n - 1] > 0;
    }
}

package dp;

// https://leetcode.com/problems/stone-game/

public class _877_StoneGame {

//  Constraints:
//  2 <= piles.length <= 500
//  piles.length is even.
//  1 <= piles[i] <= 500
//  sum(piles) is odd.

    public static boolean stoneGame(int[] piles) {
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


    public static void main(String[] args) {
        boolean g1 = stoneGame(new int[]{5, 3, 4, 5}); // true
        boolean g2 = stoneGame(new int[]{3, 7, 2, 3}); // true
        boolean g3 = stoneGame(new int[]{7, 8, 8, 10}); // true
    }
}

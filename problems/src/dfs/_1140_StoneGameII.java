package dfs;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/stone-game-ii
public class _1140_StoneGameII {

    // Alice and Bob take turns, with Alice starting first.  Initially, M = 1.
    // On each player's turn, that player can take all the stones
    // in the first X remaining piles, where 1 <= X <= 2M.  Then, we set M = max(M, X).

//    Constraints:
//            1 <= piles.length <= 100
//            1 <= piles[i] <= 10^4

    public int stoneGameII(int[] piles) {
        this.piles = piles;
        n = piles.length;

        suffixSum = new int[n];
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n-2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + this.piles[i];
        }

        int[][] dp = new int[n][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= n; j++) {
                if (i + 2 * j - 1 >= n - 1) {
                    // collect all remaining piles
                    dp[i][j] = suffixSum[i];
                } else {
                    int maxScore = 0;
                    for (int x = 1; x <= 2 * j; x++) {
                        int curScore = suffixSum[i] - suffixSum[i + x];
                        int bobScore = dp[i + x][Math.max(j, x)];
                        int remainScore = suffixSum[i + x] - bobScore;
                        maxScore = Math.max(maxScore, curScore + remainScore);
                    }
                    dp[i][j] = maxScore;
                }
            }
        }
        return dp[0][1];
    }

    private int[] piles;
    private int n;
    private int[] suffixSum;
    int[][] mem;

    public int stoneGameIIDFS(int[] piles) {
        this.piles = piles;
        n = piles.length;

        suffixSum = new int[n];
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n-2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + this.piles[i];
        }

        mem = new int[n][n + 1];

        int score = dfs(0, 1);

        return score;
    }

    private int dfs(int i, int m) {
        if (i == n) {
            return 0;
        }
        int end = i + 2 * m - 1;
        if (end >= n - 1) {
            // collect all remaining piles
            // no need to dfs
            return suffixSum[i];
        } else if (mem[i][m] > 0) {
            return mem[i][m];
        }

        int maxScore = 0;
        for (int x = 1; x <= 2 * m && i + x <= n; x++) {
            int curScore = suffixSum[i] - suffixSum[i + x];
            int bobScore = dfs(i + x, Math.max(m, x));
            int remainScore = suffixSum[i + x] - bobScore;
            maxScore = Math.max(maxScore, curScore + remainScore);
        }

        mem[i][m] = maxScore;
        return maxScore;
    }
}

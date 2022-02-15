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

    private int[] piles;
    private int n;
    private int[] prefixSum;
    int[][] mem;

    public int stoneGameII(int[] piles) {
        this.piles = piles;
        n = piles.length;

        prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + piles[i];
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
            return prefixSum[n] - prefixSum[i];
        } else if (mem[i][m] > 0) {
            return mem[i][m];
        }

        int maxScore = 0;
        for (int x = 1; x <= 2 * m && i + x <= n; x++) {
            int curScore = prefixSum[i + x] - prefixSum[i];
            int bobScore = dfs(i + x, Math.max(m, x));
            int remainScore = prefixSum[n] - prefixSum[i + x] - bobScore;
            maxScore = Math.max(maxScore, curScore + remainScore);
        }

        mem[i][m] = maxScore;
        return maxScore;
    }
}

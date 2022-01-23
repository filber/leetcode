package dfs;

// https://leetcode.com/problems/stone-game-ii
public class _1140_StoneGameII {

    // Alice and Bob take turns, with Alice starting first.  Initially, M = 1.
    // On each player's turn, that player can take all the stones
    // in the first X remaining piles, where 1 <= X <= 2M.  Then, we set M = max(M, X).
    public static int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][] mem = new int[n][n + 1];

        int[] suffixSum = new int[n];
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }

        return dfs(suffixSum, mem, 0, 1);
    }

    private static int dfs(int[] suffixSum, int[][] mem, int start, int m) {
        int n = suffixSum.length;
        if (start >= n) {
            return 0;
        }
        int end = start + 2 * m - 1;
        if (end >= n - 1) {
            // collect all remaining piles
            return suffixSum[start];
        } else if (mem[start][m] > 0) {
            return mem[start][m];
        }

        int ans = Integer.MIN_VALUE;
        for (int x = 1; x <= 2 * m && start + x < n; x++) {
            int bob = dfs(suffixSum, mem, start + x, Math.max(x, m));
            ans = Math.max(ans, suffixSum[start] - bob);
        }
        mem[start][m] = ans;
        return ans;
    }

    public int stoneGameIIDP(int[] piles) {
        int m = piles.length, sum = 0;

        int[][] dp = new int[m][m + 1];

        for (int i = m - 1; i >= 0; i--) {
            sum += piles[i];
            for (int j = 1; j <= m; j++) {
                if (i + j * 2 >= m) {
                    // collect all
                    dp[i][j] = sum;
                } else {
                    int nextMin = Integer.MAX_VALUE;
                    for (int x = 1; x <= 2 * j; x++) {
                        int nextM = Math.max(x, j);
                        int bob = dp[i + x][nextM];
                        nextMin = Math.min(nextMin, bob);
                    }
                    dp[i][j] = sum - nextMin;
                }
            }
        }
        return dp[0][1];
    }

    public static void main(String[] args) {
        // 104 [1+3+100]
        int s2 = stoneGameII(new int[]{1, 2, 3, 4, 5, 100});

        // 10 [2+4+4]
        int s1 = stoneGameII(new int[]{2, 7, 9, 4, 4});

        // 2 [1+1]
        int s3 = stoneGameII(new int[]{1, 1, 1});

        // 217
        int s4 = stoneGameII(new int[]{77, 12, 64, 35, 28, 4, 87, 21, 20});
    }
}

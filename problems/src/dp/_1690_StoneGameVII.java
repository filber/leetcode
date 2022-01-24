package dp;

// https://leetcode.com/problems/stone-game-vii/

public class _1690_StoneGameVII {

    public static int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + stones[i - 1];
        }

        int[][] dp = new int[n][n];
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n; i++) {
                int j = i + len - 1;
                if (j >= n) {
                    break;
                } else {
                    // remove left-most
                    int score1 = prefixSum[j + 1] - prefixSum[i + 1];
                    int diff1 = score1 - dp[i + 1][j];
                    // remove right-most
                    int score2 = prefixSum[j] - prefixSum[i];
                    int diff2 = score2 - dp[i][j - 1];
                    // maximize diff
                    dp[i][j] = Math.max(diff1, diff2);
                }
            }
        }

        return dp[0][n-1];
    }

    public static void main(String[] args) {
        // 6
        int d1 = stoneGameVII(new int[]{5, 3, 1, 4, 2});
        // 122
        int d2 = stoneGameVII(new int[]{7, 90, 5, 1, 100, 10, 10, 2});
    }
}

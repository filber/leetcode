package dp;

// https://leetcode.com/problems/stone-game-v/
public class _1563_StoneGameV {

    private int[] stoneValue;
    private int n;

    private int[] prefixSum;
    private int[][] mem;

    public int stoneGameV(int[] s) {
        stoneValue = s;
        n = s.length;
        prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + stoneValue[i];
        }
        int[][] dp = new int[n][n];
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                int maxScore = 0;
                for (int k = i; k < j; k++) {
                    int score = 0;
                    int leftScore = prefixSum[k + 1] - prefixSum[i]; //[i,k]
                    int rightScore = prefixSum[j + 1] - prefixSum[k + 1]; //[k+1,j]
                    if (leftScore < rightScore) {
                        score += leftScore;
                        score += dp[i][k];
                    } else if (leftScore > rightScore) {
                        score += rightScore;
                        score += dp[k + 1][j];
                    } else {
                        score += rightScore;
                        score += Math.max(dp[i][k], dp[k + 1][j]);
                    }
                    maxScore = Math.max(maxScore, score);
                }
                dp[i][j] = maxScore;
            }
        }

        return dp[0][n - 1];
    }

    public int stoneGameVDFS(int[] s) {
        stoneValue = s;
        n = s.length;
        prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + stoneValue[i];
        }

        mem = new int[n][n];
        int score = dfs(0, n - 1);
        return score;
    }

    private int dfs(int i, int j) {
        if (i == j) {
            return 0; // one stone remaining
        } else if (mem[i][j] > 0) {
            return mem[i][j];
        }

        int maxScore = 0;
        for (int k = i; k < j; k++) {
            int score = 0;
            int leftScore = prefixSum[k + 1] - prefixSum[i]; //[i,k]
            int rightScore = prefixSum[j + 1] - prefixSum[k + 1]; //[k+1,j]
            if (leftScore < rightScore) {
                score += leftScore;
                score += dfs(i, k);
            } else if (leftScore > rightScore) {
                score += rightScore;
                score += dfs(k + 1, j);
            } else {
                score += rightScore;
                score += Math.max(dfs(i, k), dfs(k + 1, j));
            }
            maxScore = Math.max(maxScore, score);
        }

        mem[i][j] = maxScore;
        return maxScore;
    }
}

package dp;

// https://leetcode.com/problems/stone-game-v/
public class _1563_StoneGameV {

    public static int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        if (n == 1) {
            return 0;
        }

        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + stoneValue[i - 1];
        }

        int[][] dp = new int[n][n];
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n; i++) {
                int j = i + len - 1;
                if (j >= n) {
                    break;
                }
                int max = 0;
                for (int k = i; k < j; k++) {
                    int sum = 0;
                    // left [i,k]
                    int left = prefixSum[k + 1] - prefixSum[i];
                    // right [k+1,j]
                    int right = prefixSum[j + 1] - prefixSum[k + 1];
                    if (left > right) {
                        sum = right + dp[k + 1][j];
                    } else if (left < right) {
                        sum = left + dp[i][k];
                    } else {
                        sum = Math.max(dp[i][k], dp[k + 1][j]) + left;
                    }
                    max = Math.max(max, sum);
                }
                dp[i][j] = max;
            }
        }

        return dp[0][n - 1];
    }

    public static int stoneGameVDFS(int[] stoneValue) {
        int n = stoneValue.length;
        if (n == 1) {
            return 0;
        }

        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + stoneValue[i - 1];
        }

        int[][] mem = new int[n][n];
        return dfs(stoneValue, prefixSum, mem, 0, n - 1);
    }

    private static int dfs(int[] stoneValue, int[] prefixSum, int[][] mem, int start, int end) {
        if (start == end) {
            // remaining just one stone
            return 0;
        } else if (mem[start][end] > 0) {
            return mem[start][end];
        }

        int max = 0;
        for (int i = start; i < end; i++) {
            int sum = 0;
            int left = prefixSum[i + 1] - prefixSum[start];
            int right = prefixSum[end + 1] - prefixSum[i + 1];
            if (left > right) {
                // throw left
                sum = right + dfs(stoneValue, prefixSum, mem, i + 1, end);
            } else if (left < right) {
                // throw right
                sum = left + dfs(stoneValue, prefixSum, mem, start, i);
            } else {
                // left == right
                // try both side
                sum = Math.max(left + dfs(stoneValue, prefixSum, mem, start, i),
                        right + dfs(stoneValue, prefixSum, mem, i + 1, end));
            }
            max = Math.max(max, sum);
        }
        mem[start][end] = max;
        return max;
    }


    public static void main(String[] args) {
        // 18
        int m1 = stoneGameV(
                new int[]{6, 2, 3, 4, 5, 5});

        // 28
        int m2 = stoneGameV(
                new int[]{7, 7, 7, 7, 7, 7, 7});

        // 0
        int m3 = stoneGameV(
                new int[]{4});
    }
}

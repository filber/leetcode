package dp;

//https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/

public class _EX_0_1_Knapsack {

    public int knapsack(int capacity, int weight[], int value[]) {
        int n = weight.length;
        int[] dp = new int[capacity + 1];
        for (int i = 1; i <= n; i++) {
            int w = weight[i - 1];
            int v = value[i - 1];
            for (int j = capacity; j >= w; j--) {
                dp[j] = Math.max(dp[j], dp[j - w] + v);
            }
        }

        return dp[capacity];
    }

    public int knapsack2D(int capacity, int weight[], int value[]) {
        int n = weight.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            int w = weight[i - 1];
            int v = value[i - 1];
            for (int j = 1; j <= capacity; j++) {
                if (j < w) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
                }
            }
        }

        return dp[n][capacity];
    }
}

package dp;

//https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/

public class _EX_0_1_Knapsack {

    public int knapsack(int capacity, int weight[], int value[]) {
        int n = value.length;
        int[] dp = new int[capacity + 1];
        for (int i = 0; i < n; i++) {
            int w = weight[i];
            int v = value[i];
            for (int j = capacity; j >= w; j--) {
                if (j - w >= 0) {
                    dp[j] = Math.max(dp[j], dp[j - w] + v);
                }
            }
        }
        return dp[capacity];
    }

}

package dp;

// https://leetcode.com/problems/burst-balloons/

public class _312_BurstBalloons {

    public int maxCoins(int[] nums) {
        int[] N = new int[nums.length + 2];
        N[0] = 1;
        N[N.length - 1] = 1;
        for (int i = 0; i < nums.length; i++) {
            N[i + 1] = nums[i];
        }

        int n = N.length;
        int[][] dp = new int[n][n];

        // Init diagonal
        for (int i = 1; i < n - 1; i++) {
            dp[i][i] = N[i - 1] * N[i] * N[i + 1];
        }

        // Iterate
        for (int len = 2; len <= nums.length; len++) {
            for (int i = 1; i + len - 1 <= nums.length; i++) {
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    int prev = N[i-1];
                    int cur = N[k];
                    int next = N[j + 1];
                    dp[i][j] = Math.max(dp[i][j], dp[i][k - 1] + dp[k + 1][j] + prev * cur * next);
                }
            }
        }
        return dp[1][nums.length];
    }
}

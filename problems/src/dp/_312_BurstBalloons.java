package dp;

//[Dynamic Programming]

// https://leetcode.com/problems/burst-balloons/
public class _312_BurstBalloons {

    public static int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n+1] = 1;
        for (int i = 1; i <= n; i++) {
            arr[i] = nums[i - 1];
        }
        int[][] dp = new int[n + 2][n + 2];
        dp[0][0] = 1;
        dp[n + 1][n + 1] = 1;
        for (int len = 1; len <= n; len++) {
            for (int i = 1; i <= n; i++) {
                int j = len - 1 + i;
                if (j > n) {
                    break;
                }
                if (len == 1) {
                    dp[i][j] = arr[i - 1] * arr[i] * arr[i + 1];
                } else {
                    int left = arr[i - 1];
                    int right = arr[j + 1];
                    int max = Integer.MIN_VALUE;
                    for (int k = i; k <= j; k++) {
                        max = Math.max(max, left * arr[k] * right + dp[i][k - 1] + dp[k + 1][j]);
                    }
                    dp[i][j] = max;
                }
            }
        }

        return dp[1][n];
    }

    public static void main(String[] args) {
        int m1 = maxCoins(new int[]{1, 5}); // 10
        int m2 = maxCoins(new int[]{3, 1, 5, 8}); //167
        int m3 = maxCoins(new int[]{4}); // 4
    }
}

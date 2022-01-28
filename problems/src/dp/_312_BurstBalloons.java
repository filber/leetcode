package dp;

//[Dynamic Programming]

// https://leetcode.com/problems/burst-balloons/
public class _312_BurstBalloons {

    public static int maxCoins(int[] nums) {
        int[] balloons = new int[nums.length + 2];
        balloons[0] = 1;
        balloons[balloons.length - 1] = 1;
        for (int i = 0; i < nums.length; i++) {
            balloons[i + 1] = nums[i];
        }

        int n = nums.length;
        int[][] dp = new int[n + 2][n + 2];

        for (int len = 1; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    int kVal = balloons[i-1]*balloons[k]*balloons[j+1];
                    dp[i][j] = Math.max(dp[i][j], dp[i][k - 1] + dp[k + 1][j] + kVal);
                }
            }
        }

        return dp[1][n];
    }

    public static void main(String[] args) {
        int m3 = maxCoins(new int[]{4}); // 4
        int m1 = maxCoins(new int[]{1, 5}); // 10
        int m2 = maxCoins(new int[]{3, 1, 5, 8}); //167
    }
}

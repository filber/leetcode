package dp;

// https://leetcode.com/problems/climbing-stairs/
public class _70_ClimbingStairs {

    public int climbStairs(int n) {
      int[] dp = new int[n + 1];
      dp[0] = 1; // empty
      dp[1] = 1; // one stair
      for (int i = 2; i <= n; i++) {
          dp[i] = dp[i - 1] + dp[i - 2];
      }
      return dp[n];
    }
}

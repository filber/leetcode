package dp;

//https://leetcode.com/problems/house-robber/
public class _198_HouseRobber {

    public int rob(int[] nums) {
        int n = nums.length;

        // dp[i]: max amount for robbing nums[1..i]
        int[] dp = new int[n + 1];
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            int amt = nums[i - 1];
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + amt);
        }
        return dp[n];
    }
}

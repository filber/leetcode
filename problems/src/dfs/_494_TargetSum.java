package dfs;

//https://leetcode.com/problems/target-sum/


public class _494_TargetSum {

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if ((sum + target) % 2 != 0) {
            return 0;
        }
        int targetSum = (sum + target) / 2;
        if (targetSum < 0) {
            return 0;
        }
        int[] dp = new int[targetSum + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = targetSum; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[targetSum];
    }
}

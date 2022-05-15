package dfs;

//https://leetcode.com/problems/target-sum/


public class _494_TargetSum {

    int ways = 0;
    int target;

    public int findTargetSumWays(int[] nums, int target) {
        this.target = target;
        dfs(nums, 0, 0, 0);
        return ways;
    }

    private void dfs(int[] nums, int left, int right, int i) {
        if (i == nums.length) {
            ways += left - right == target ? 1 : 0;
            return;
        }
        dfs(nums, left + nums[i], right, i + 1);
        dfs(nums, left, right + nums[i], i + 1);
    }

    // 0/1 Knapsack
    public int findTargetSumWaysKnapsack(int[] nums, int target) {
        int sum = 0;
        for (int val : nums) {
            sum += val;
        }
        if ((sum + target) % 2 != 0) {
            return 0;
        }
        int x = (sum + target) / 2;
        if (x < 0) {
            return 0;
        }
        int m = nums.length;
        int[] dp = new int[x + 1];
        dp[0] = 1;
        for (int i = 1; i <= m; i++) {
            // must update dp[0]
            for (int j = x; j >= 0; j--) {
                if (j >= nums[i - 1]) {
                    dp[j] += dp[j - nums[i - 1]];
                }
            }
        }
        return dp[x];
    }
}

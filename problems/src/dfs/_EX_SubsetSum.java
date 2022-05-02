package dfs;

//https://www.geeksforgeeks.org/subset-sum-problem-dp-25/

public class _EX_SubsetSum {

    public boolean isSubsetSumDFS(int[] nums, int sum) {
        Boolean[] memo = new Boolean[sum + 1];
        memo[0] = true;
        return dfs(nums, memo, 0, sum);
    }

    private boolean dfs(int[] nums, Boolean[] memo, int i, int sum) {
        if (sum < 0) {
            return false;
        } else if (i == nums.length) {
            return sum == 0;
        } else if (memo[sum] != null) {
            return memo[sum];
        }
        if (dfs(nums, memo, i + 1, sum - nums[i])) {
            memo[sum] = true;
            return true;
        }
        memo[sum] = dfs(nums, memo, i + 1, sum);
        return memo[sum];
    }

    public boolean isSubsetSum(int[] nums, int sum) {
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            int w = nums[i];
            for (int j = sum; j >= w; j--) {
                if (dp[j - w]) {
                    dp[j] = true;
                }
            }
        }
        return dp[sum];
    }
}

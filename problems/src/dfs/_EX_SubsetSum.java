package dfs;

//https://www.geeksforgeeks.org/subset-sum-problem-dp-25/

public class _EX_SubsetSum {

    public boolean isSubsetSum(int[] nums, int sum) {
        Boolean[] memo = new Boolean[sum + 1];
        memo[0] = true;

        return dfs(nums, memo, 0, sum);
    }

    private boolean dfs(int[] nums, Boolean[] memo, int i, int sum) {
        if (i == nums.length) {
            return sum == 0;
        } else if (memo[sum] != null) {
            return memo[sum];
        }

        if (sum - nums[i] >= 0 && dfs(nums, memo, i + 1, sum - nums[i])) {
            return true;
        }

        memo[sum] = dfs(nums, memo, i + 1, sum);
        return memo[sum];
    }

    public boolean isSubsetSumKnapsack(int[] nums, int sum) {
        int n = nums.length;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true; // the sum of an empty set is 0
        for (int i = 0; i < n; i++) {
            for (int j = sum; j > 0; j--) {
                int w = nums[i];
                if (j - w >= 0 && dp[j - w]) {
                    dp[j] = true;
                }
            }
        }

        return dp[sum];
    }
}

package dfs;

//https://leetcode.com/problems/partition-equal-subset-sum/

import java.util.Arrays;

public class _416_PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int half = sum / 2;

        //memo[j]: exists an approach that can add up to j by selecting all items
        Boolean[] memo = new Boolean[half + 1];
        memo[0] = true;

        return dfs(nums, memo, 0, half);
    }

    private boolean dfs(int[] nums, Boolean[] memo, int i, int target) {
        if (i == nums.length) {
            return target == 0;
        } else if (memo[target] != null) {
            return memo[target];
        }

        int w = nums[i];
        // try first time
        if (target >= w && dfs(nums, memo, i + 1, target - w)) {
            memo[target] = true;
            return true;
        }
        // if first time failed, we don't set memo[target]=false
        // try second time
        memo[target] = dfs(nums, memo, i + 1, target);
        return memo[target];
    }

    public boolean canPartitionKnapsack(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int half = sum / 2;

        //dp[j]: exists an approach that can add up to j by selecting all items
        boolean[] dp = new boolean[half + 1];
        dp[0] = true;

        // 0/1 Knapsack
        for (int i = 0; i < nums.length; i++) {
            for (int j = half; j > 0; j--) {
                int w = nums[i];
                if (j >= w && dp[j - w]) {
                    dp[j] = true;
                }
            }
        }
        return dp[half];
    }
}

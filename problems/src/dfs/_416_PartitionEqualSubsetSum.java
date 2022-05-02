package dfs;

//https://leetcode.com/problems/partition-equal-subset-sum/

import java.util.Arrays;

public class _416_PartitionEqualSubsetSum {

    public boolean canPartitionDFS(int[] nums) {
        int total = Arrays.stream(nums).sum();
        if (total % 2 != 0) {
            return false;
        }
        int targetSum = total / 2;
        Boolean[] memo = new Boolean[targetSum + 1];
        memo[0] = true;
        return dfs(nums, memo, 0, targetSum);
    }

    private boolean dfs(int[] nums, Boolean[] memo, int i, int target) {
        if (target < 0) {
            return false;
        } else if (i == nums.length) {
            return target == 0;
        } else if (memo[target] != null) {
            return memo[target];
        }
        if (dfs(nums, memo, i + 1, target - nums[i])) {
            memo[target] = true;
            return true;
        }
        memo[target] = dfs(nums, memo, i + 1, target);
        return memo[target];
    }

    public boolean canPartition(int[] nums) {
        int total = Arrays.stream(nums).sum();
        if (total % 2 != 0) {
            return false;
        }
        int targetSum = total / 2;
        boolean[] dp = new boolean[targetSum + 1];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            int w = nums[i];
            for (int j = targetSum; j >= w; j--) {
                if (dp[j - w]) {
                    dp[j] = true;
                }
            }
        }
        return dp[targetSum];
    }
}

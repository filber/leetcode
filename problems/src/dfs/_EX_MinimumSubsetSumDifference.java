package dfs;

import java.util.Arrays;

public class _EX_MinimumSubsetSumDifference {

    int minDiff = Integer.MAX_VALUE;
    int totalSum = 0;

    public int minSumDiffDFS(int[] nums) {
        for (int val : nums) {
            totalSum += val;
        }
        dfs(nums, 0, 0);
        return minDiff;
    }

    private void dfs(int[] nums, int sum, int i) {
        if (i == nums.length) {
            minDiff = Math.min(minDiff, Math.abs(totalSum - 2 * sum));
            return;
        }
        dfs(nums, sum + nums[i], i + 1);
        dfs(nums, sum, i + 1);
    }

    public int minSumDiff(int[] nums) {
        int sum = 0;
        for (int val : nums) {
            sum += val;
        }
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true; // EMPTY SET
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int w = nums[i];
            for (int j = sum; j > 0; j--) {
                if (j >= w) {
                    dp[j] = dp[j - w];
                    diff = Math.min(diff, Math.abs(sum - j - j));
                }
            }
        }
        return diff;
    }
}

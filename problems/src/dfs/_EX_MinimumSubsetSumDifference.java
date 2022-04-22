package dfs;

import java.util.Arrays;

public class _EX_MinimumSubsetSumDifference {

    int minDiff = Integer.MAX_VALUE;
    int sum;
    int[] nums;

    // Time Complexity: O(n^2)
    public int minSumDiff(int[] nums) {
        this.nums = nums;
        sum = Arrays.stream(nums).sum();
        dfs(0, 0);
        return minDiff;
    }

    private void dfs(int i, int curSum) {
        if (i == nums.length) {
            minDiff = Math.min(minDiff, Math.abs(2 * curSum - sum));
            return;
        }
        dfs(i + 1, curSum);
        dfs(i + 1, curSum + nums[i]);
    }

    // Time Complexity : O(n*sum)
    public int minSumDiffKnapsack(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            for (int j = sum; j > 0; j--) {
                int w = nums[i];
                if (j >= w && dp[j - w]) {
                    dp[j] = true;
                    minDiff = Math.min(minDiff, Math.abs(2 * j - sum));
                }
            }
        }

        return minDiff;
    }
}

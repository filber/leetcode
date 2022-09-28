package dfs;

//https://www.geeksforgeeks.org/count-of-subsets-with-sum-equal-to-x/

import java.util.HashMap;
import java.util.Map;

public class _EX_CountOfSubsetsWithSumEqualToX {

    public int findCntDFS(int[] nums, int X) {
        int[][] memo = new int[nums.length][X + 1];
        for (int i = 0; i < nums.length; i++) {
            memo[i][0] = 1;
        }
        return dfs(nums, memo, X, 0);
    }

    private int dfs(int[] nums, int[][] memo, int sum, int i) {
        if (sum == 0) {
            return 1;
        } else if (i == nums.length) {
            return 0;
        } else if (sum < 0) {
            return 0;
        } else if (memo[i][sum] != 0) {
            return memo[i][sum];
        }

        int count = 0;
        count += dfs(nums, memo, sum - nums[i], i + 1);
        count += dfs(nums, memo, sum, i + 1);
        memo[i][sum] = count;
        return count;
    }

    // 0/1 Knapsack
    public int findCnt(int[] nums, int X) {
        int m = nums.length;
        int[] dp = new int[X + 1];
        dp[0] = 1;

        for (int i = 1; i <= m; i++) {
            int w = nums[i - 1];
            for (int j = X; j >= w; j--) {
                dp[j] += dp[j - w];
            }
        }
        return dp[X];
    }
}

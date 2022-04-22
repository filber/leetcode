package dfs;

//https://www.geeksforgeeks.org/count-of-subsets-with-sum-equal-to-x/

import java.util.HashMap;
import java.util.Map;

public class _EX_CountOfSubsetsWithSumEqualToX {

    int[] nums;
    int n;
    int X;
    Map<Integer, Integer>[] memo;

    public int findCntDFS(int[] nums, int X) {
        this.nums = nums;
        n = nums.length;
        this.X = X;
        memo = new Map[n];
        return dfs(0, X);
    }

    private int dfs(int i, int sum) {
        if (sum == 0) {
            return 1;
        } else if (sum < 0) {
            return 0;
        } else if (i == n) {
            return 0;
        } else if (memo[i] != null && memo[i].containsKey(sum)) {
            return memo[i].get(sum);
        }
        int count = 0;
        count += dfs(i + 1, sum - nums[i]);
        count += dfs(i + 1, sum);
        if (memo[i] == null) {
            memo[i] = new HashMap<>();
        }
        memo[i].put(sum, count);
        return count;
    }


    // Knapsack
    public int findCnt(int[] nums, int X) {
        int n = nums.length;
        int[] dp = new int[X + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            int w = nums[i];
            for (int j = X; j > 0; j--) {
                if (j >= w) {
                    dp[j] += dp[j - w];
                }
            }
        }

        return dp[X];
    }
}

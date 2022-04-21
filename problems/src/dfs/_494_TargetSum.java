package dfs;

//https://leetcode.com/problems/target-sum/

import java.util.Arrays;

public class _494_TargetSum {

    int ways = 0;
    int n;
    int[] nums;
    int target;

    public int findTargetSumWaysBacktracking(int[] nums, int target) {
        this.nums = nums;
        n = nums.length;
        this.target = target;
        backtracking(0, 0, 0);
        return ways;
    }

    private void backtracking(int i, int left, int right) {
        if (i == n) {
            ways += left - right == target ? 1 : 0;
            return;
        }
        int w = nums[i];
        backtracking(i + 1, left + w, right);
        backtracking(i + 1, left, right + w);
    }

    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        int doubleA = target + sum;
        if (doubleA % 2 != 0 || target > sum || target < -sum) {
            return 0;
        }
        int A = Math.abs(doubleA / 2);

        // how many subsets have the sum equals to target
        int[] dp = new int[A + 1];
        dp[0] = 1;// empty subset
        for (int i = 0; i < nums.length; i++) {
            int w = nums[i];
            for (int j = A; j >= 0; j--) {
                if (j >= w) {
                    dp[j] += dp[j - w];
                }
            }
        }
        return dp[A];
    }
}

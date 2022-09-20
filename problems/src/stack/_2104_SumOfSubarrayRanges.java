package stack;

//https://leetcode.com/problems/sum-of-subarray-ranges/

import java.util.Arrays;

public class _2104_SumOfSubarrayRanges {

    public long subArrayRanges(int[] arr) {
        return 0;
    }

    public long subArrayRangesDP(int[] nums) {
        long sum = 0L;
        int n = nums.length;
        int[][][] dp = new int[n][n][2];
        for (int i = 0; i < n; i++) {
            dp[i][i][0] = nums[i];
            dp[i][i][1] = nums[i];
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < nums.length; i++) {
                int j = i + len - 1;
                dp[i][j][0] = Math.min(dp[i][j - 1][0], nums[j]);
                dp[i][j][1] = Math.max(dp[i][j - 1][1], nums[j]);
                sum += dp[i][j][1] - dp[i][j][0];
            }
        }

        return sum;
    }
}

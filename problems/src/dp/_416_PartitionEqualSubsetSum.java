package dp;

//https://leetcode.com/problems/partition-equal-subset-sum/

import java.util.Arrays;

public class _416_PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
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

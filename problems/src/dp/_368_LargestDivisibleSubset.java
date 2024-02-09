package dp;

//https://leetcode.com/problems/largest-divisible-subset/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _368_LargestDivisibleSubset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        // dp[i][0]: the largest size of the subset if it contains nums[i]
        // dp[i][1]: index of the previous num contained in subset
        int[][] dp = new int[n][2];
        dp[0][0] = 1;
        dp[0][1] = -1; // prev
        int largest = 1;
        int largestIdx = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = 1;
            dp[i][1] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && dp[j][0] + 1 > dp[i][0]) {
                    dp[i][0] = dp[j][0] + 1;
                    dp[i][1] = j;
                }
            }

            if (dp[i][0] > largest) {
                largestIdx = i;
                largest = dp[i][0];
            }
        }

        List<Integer> result = new ArrayList<>();
        result.add(nums[largestIdx]);
        int idx = dp[largestIdx][1];
        while (idx != -1) {
            result.add(nums[idx]);
            idx = dp[idx][1];
        }
        return result;
    }
}

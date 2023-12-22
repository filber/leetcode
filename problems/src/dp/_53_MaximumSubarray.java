package dp;
// https://leetcode.com/problems/maximum-subarray/

public class _53_MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        dp[0] = nums[0];
        int rst = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            rst = Math.max(dp[i], rst);
        }
        return rst;
    }
}

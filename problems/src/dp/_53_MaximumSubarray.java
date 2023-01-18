package dp;
// https://leetcode.com/problems/maximum-subarray/

public class _53_MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int dp = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            dp = Math.max(nums[i], dp + nums[i]);
            max = Math.max(dp, max);
        }
        return max;
    }
}

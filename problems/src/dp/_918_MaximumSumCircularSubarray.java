package dp;

//https://leetcode.com/problems/maximum-sum-circular-subarray/

public class _918_MaximumSumCircularSubarray {

    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int sum = nums[0];
        int dpMax = nums[0];
        int max = dpMax;
        int dpMin = nums[0];
        int min = dpMin;
        for (int i = 1; i < n; i++) {
            dpMax = Math.max(nums[i], dpMax + nums[i]);
            max = Math.max(max, dpMax);
            dpMin = Math.min(nums[i], dpMin + nums[i]);
            min = Math.min(min, dpMin);
            sum += nums[i];
        }
        if (max < 0) {
            return max;
        }
        return Math.max(max, sum - min);
    }
}

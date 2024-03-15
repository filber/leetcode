package array_matrix;

//https://leetcode.com/problems/minimum-size-subarray-sum/

public class _209_MinimumSizeSubarraySum {

    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int l = 0;
        int n = nums.length;
        int len = Integer.MAX_VALUE;

        for (int r = 0; r < n; r++) {
            sum += nums[r];
            while (sum >= target) {
                len = Math.min(len, r - l + 1);
                sum -= nums[l];
                l++;
            }
        }

        if (len == Integer.MAX_VALUE) {
            return 0;
        }
        return len;
    }
}

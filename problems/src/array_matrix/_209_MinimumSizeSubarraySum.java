package array_matrix;

//https://leetcode.com/problems/minimum-size-subarray-sum/

public class _209_MinimumSizeSubarraySum {

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length, r = 0, l = 0, sum = nums[0];
        if (sum >= target) {
            return 1;
        }
        int len = Integer.MAX_VALUE;
        while (r < n) {
            if (sum >= target) {
                len = Math.min(len, r - l + 1);
                sum -= nums[l++];
            } else {
                r++;
                if (r < n) {
                    sum += nums[r];
                }
            }
        }

        return len == Integer.MAX_VALUE ? 0 : len;
    }
}

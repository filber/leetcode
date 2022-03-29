package array_matrix;

//https://leetcode.com/problems/minimum-size-subarray-sum/

public class _209_MinimumSizeSubarraySum {

    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = 0;
        int n = nums.length;
        int sum = nums[0];
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

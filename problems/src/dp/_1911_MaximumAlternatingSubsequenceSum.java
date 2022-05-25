package dp;

//https://leetcode.com/problems/maximum-alternating-subsequence-sum/

public class _1911_MaximumAlternatingSubsequenceSum {

    public long maxAlternatingSum(int[] nums) {
        long odd = nums[0];
        long even = 0;

        for (int i = 1; i < nums.length; i++) {
            odd = Math.max(nums[i], Math.max(even + nums[i], odd));
            even = Math.max(even, odd - nums[i]);
        }
        return Math.max(odd, even);
    }
}

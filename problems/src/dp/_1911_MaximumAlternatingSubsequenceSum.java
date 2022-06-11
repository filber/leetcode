package dp;

//https://leetcode.com/problems/maximum-alternating-subsequence-sum/

public class _1911_MaximumAlternatingSubsequenceSum {

    public long maxAlternatingSum(int[] nums) {
        long odd = nums[0];
        long even = 0;
        for (int i = 1; i < nums.length; i++) {
            long tmpOdd = odd;
            odd = Math.max(odd, Math.max(even + nums[i], nums[i]));
            even = Math.max(even, tmpOdd - nums[i]);
        }
        return Math.max(even, odd);
    }
}

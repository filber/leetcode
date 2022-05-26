package dp;

//https://leetcode.com/problems/longest-continuous-increasing-subsequence/

public class _674_LongestContinuousIncreasingSubsequence {

    public int findLengthOfLCIS(int[] nums) {
        int curLen = 1;
        int maxLen = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                curLen++;
            } else {
                curLen = 1;
            }
            maxLen = Math.max(maxLen,curLen);
        }
        return maxLen;
    }
}

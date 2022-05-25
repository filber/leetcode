package dp;

// https://leetcode.com/problems/longest-increasing-subsequence/

public class _300_LongestIncreasingSubsequence {

    // O(N*logN)
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int len = 0;
        for (int val : nums) {
            int l = 0, r = len;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (dp[mid] >= val) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }

            dp[l] = val;
            if (l == len) {
                len++;
            }
        }
        return len;
    }
}

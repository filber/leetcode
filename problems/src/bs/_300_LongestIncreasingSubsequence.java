package bs;

// https://leetcode.com/problems/longest-increasing-subsequence/

import java.util.Arrays;

public class _300_LongestIncreasingSubsequence {

    // O(N*logN)
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int len = 0;
        for (int i = 0; i < n; i++) {
            int j = search(dp, len, nums[i]);
            if (j + 1 > len) {
                len = j + 1;
            }
        }
        return len;
    }

    private int search(int[] dp, int len, int target) {
        int l = 0;
        int r = len;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (dp[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        dp[l] = target;
        return l;
    }
}

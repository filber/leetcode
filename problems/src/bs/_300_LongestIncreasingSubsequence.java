package bs;

// https://leetcode.com/problems/longest-increasing-subsequence/

import java.util.Arrays;

public class _300_LongestIncreasingSubsequence {

    // O(N*logN)
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] A = new int[n];
        A[0] = nums[0];
        int len = 1;
        for (int i = 1; i < n; i++) {
            int j = searchInsert(A, len, nums[i]);
            len = Math.max(len, j + 1);
        }
        return len;
    }

    private int searchInsert(int[] A, int len, int target) {
        int l = 0, r = len;
        while (l < r) {
            int mid = (l + r) / 2;
            if (A[mid] >= target) {
                r = mid;
            } else {
                // A[mid] < target
                l = mid + 1;
            }
        }

        A[l] = target;
        return l;
    }
}

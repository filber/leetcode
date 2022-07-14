package array_matrix;

//https://leetcode.com/problems/longest-consecutive-sequence/

import java.util.Arrays;

public class _128_LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int l = 0;
        int r = 0;
        int maxLen = 0;
        int len = 1;
        while (r < n) {
            if (nums[l] == nums[r]) {
                l = r;
                r++;
            } else if (nums[l] + 1 == nums[r]) {
                len++;
                r++;
                l++;
            } else {
                l = r;
                len = 1;
            }
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}

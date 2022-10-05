package sw;

//https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/description/

import java.util.ArrayDeque;
import java.util.Deque;

public class _1438_LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {

    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> minQueue = new ArrayDeque<>();
        Deque<Integer> maxQueue = new ArrayDeque<>();

        int l = 0, ans = 0;
        for (int r = 0; r < nums.length; r++) {
            while (!minQueue.isEmpty() && minQueue.getLast() > nums[r]) {
                minQueue.pollLast();
            }

            minQueue.addLast(nums[r]);
            while (!maxQueue.isEmpty() && maxQueue.getLast() < nums[r]) {
                maxQueue.pollLast();
            }
            maxQueue.addLast(nums[r]);

            while (maxQueue.getFirst() - minQueue.getFirst() > limit) {
                if (nums[l] == minQueue.getFirst()) {
                    minQueue.pollFirst();
                }
                if (nums[l] == maxQueue.getFirst()) {
                    maxQueue.pollFirst();
                }
                l++;
            }

            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}

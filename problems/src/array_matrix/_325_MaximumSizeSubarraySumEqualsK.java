package array_matrix;

// https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/

import java.util.HashMap;
import java.util.Map;

public class _325_MaximumSizeSubarraySumEqualsK {

    // Given an array nums and a target value k,
    // find the maximum length of a subarray that sums to k.
    // If there isn't one, return 0 instead.
    public static int maxSubArrayLen(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // sentry
        int prefixSum = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];
            if (map.containsKey(prefixSum - k)) {
                int j = map.get(prefixSum - k);
                maxLen = Math.max(maxLen, i - j);
            }
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        // 4 [1,-1,5,-2]
        int m1 = maxSubArrayLen(new int[]{1, -1, 5, -2, 3}, 3);
        // 2 [-1,2]
        int m2 = maxSubArrayLen(new int[]{-2, -1, 2, 1}, 1);
    }
}

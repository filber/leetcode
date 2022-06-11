package bs;

//https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/

import java.util.HashMap;
import java.util.Map;

public class _1658_MinimumOperationsToReduceXToZero {

    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        Map<Integer, Integer> suffixMap = new HashMap<>();

        int sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += nums[i];
            suffixMap.put(sum, i);
        }

        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            int prefix = prefixSum[i];
            if (prefix == x) {
                minLen = Math.min(minLen, i);
            } else if (prefix > x) {
                break;
            } else {
                int val = x - prefix;
                Integer rightIdx = suffixMap.get(val);
                if (rightIdx != null && i <= rightIdx) {
                    minLen = Math.min(minLen, i + n - rightIdx);
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}

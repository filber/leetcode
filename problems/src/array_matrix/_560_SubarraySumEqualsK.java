package array_matrix;

//https://leetcode.com/problems/subarray-sum-equals-k/

import java.util.HashMap;
import java.util.Map;

public class _560_SubarraySumEqualsK {

    //    Constraints:
//            1 <= nums.length <= 2 * 104
//            -1000 <= nums[i] <= 1000
//            -10^7 <= k <= 10^7
    public static int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int prefixSum = 0;
        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];
            if (prefixSum == k) {
                cnt++;
            }
            int diff = prefixSum - k;
            if (map.containsKey(diff)) {
                cnt += map.get(diff);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return cnt;
    }

    public static void main(String[] args) {
        // 2
        int c1 = subarraySum(new int[]{1, 1, 1}, 2);
        // 2
        int c2 = subarraySum(new int[]{1, 2, 3}, 3);
        // 5
        int c3 = subarraySum(new int[]{-1, 1, -1, 2, -2, 4, -2}, 0);
    }
}

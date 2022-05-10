package array_matrix;

//https://leetcode.com/problems/max-number-of-k-sum-pairs/

import java.util.HashMap;
import java.util.Map;

public class _1679_MaxNumberOfKSumPairs {

    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : nums) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        int operations = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int val = entry.getKey();
            int cnt = entry.getValue();
            int symmetryVal = k - val;
            int symmetryCnt = map.getOrDefault(symmetryVal, 0);
            if (symmetryCnt == 0) {
                continue;
            }

            if (k % 2 == 0 && symmetryVal == k / 2) {
                operations += 2 * (cnt / 2);
            } else {
                operations += Math.min(cnt, symmetryCnt);
            }
        }

        operations /= 2;

        return operations;
    }
}

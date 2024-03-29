package hmap;

//https://leetcode.com/problems/max-number-of-k-sum-pairs/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _1679_MaxNumberOfKSumPairs {

    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        int operations = 0;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum == k) {
                operations += 1;
                l++;
                r--;
            } else if (sum < k) {
                l++;
            } else {
                r--;
            }
        }
        return operations;
    }

    public int maxOperationsHM(int[] nums, int k) {
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

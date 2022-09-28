package hmap;

//https://leetcode.com/problems/subarray-sum-equals-k/

import java.util.HashMap;
import java.util.Map;

public class _560_SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        map.put(0, 1); // initial EMPTY count
        for (int val : nums) {
            sum += val;
            int remain = sum - k;
            int freq = map.getOrDefault(remain, 0);
            count += freq;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}

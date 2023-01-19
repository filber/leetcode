package hmap;

//https://leetcode.com/problems/subarray-sums-divisible-by-k/description/

import java.util.HashMap;
import java.util.Map;

public class _974_SubarraySumsDivisibleByK {

    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            int mod = (sum % k + k) % k;
            int exist = map.getOrDefault(mod, 0);
            count += exist;
            map.put(mod, exist + 1);
        }
        return count;
    }
}

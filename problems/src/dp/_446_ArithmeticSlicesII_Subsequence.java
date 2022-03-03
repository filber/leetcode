package dp;

//https://leetcode.com/problems/arithmetic-slices-ii-subsequence/

import java.util.HashMap;
import java.util.Map;

public class _446_ArithmeticSlicesII_Subsequence {

    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        Map<Long, Integer>[] maps = new Map[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            Map<Long, Integer> map = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long diff = nums[i] - nums[j];
                int preCnt = maps[j].getOrDefault(diff, 0);
                map.put(diff, map.getOrDefault(diff, 0) + preCnt + 1);
                ans += preCnt;
            }

            maps[i] = map;
        }

        return ans;
    }
}

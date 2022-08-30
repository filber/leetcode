package hmap;

//https://leetcode.com/problems/split-array-into-consecutive-subsequences/

import java.util.HashMap;
import java.util.Map;

public class _659_SplitArrayIntoConsecutiveSubsequences {

    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int cnt = map.getOrDefault(num, 0);
            map.put(num, cnt + 1);
        }

        for (int i = 0; i < nums.length; i++) {
            int next = nums[i];
            int cnt = 1;
            int len = 0;
            while (cnt <= map.getOrDefault(next, 0)) {
                cnt = map.getOrDefault(next, 0);
                map.put(next, cnt - 1);
                next++;
                len++;
            }

            if (len > 0 && len < 3) {
                return false;
            }
        }

        return true;
    }
}

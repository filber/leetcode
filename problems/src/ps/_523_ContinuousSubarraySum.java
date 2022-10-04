package ps;

//https://leetcode.com/problems/continuous-subarray-sum/

import java.util.HashMap;

public class _523_ContinuousSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int prefix = 0;
        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            int r = prefix % k;
            Integer prev = map.get(r);
            if (prev == null) {
                map.put(r, i);
            } else if (prev < i - 1) {
                return true;
            }
        }
        return false;
    }
}

package sw;

//https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/

import java.util.HashMap;
import java.util.Map;

public class _2958_LengthOfLongestSubarrayWithAtMostKFrequency {

    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int l = 0;
        int len = 0;
        for (int r = 0; r < nums.length; r++) {
            int val = nums[r];
            Integer cnt = map.getOrDefault(val, 0);
            cnt++;
            while (l < r && cnt > k) {
                int removed = nums[l];
                if (removed == val) {
                    cnt--;
                } else {
                    int removedCnt = map.get(removed);
                    removedCnt--;
                    map.put(removed, removedCnt);
                }
                l++;
            }
            map.put(val, cnt);
            len = Math.max(len, r - l + 1);
        }
        return len;
    }
}

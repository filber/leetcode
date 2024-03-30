package sw;

//https://leetcode.com/problems/subarrays-with-k-different-integers/

import java.util.HashMap;
import java.util.Map;

public class _992_SubarraysWithKDifferentIntegers {

    public int subarraysWithKDistinct(int[] nums, int k) {
        int cnt1 = subarrays(nums, k);
        int cnt2 = subarrays(nums, k + 1);
        return cnt1 - cnt2;
    }

    /**
     * count sub-arrays with at least k different integers
     */
    private int subarrays(int[] nums, int k) {
        int[] map = new int[nums.length + 1];
        int distinct = 0;
        int l = 0;
        int res = 0;
        for (int r = 0; r < nums.length; r++) {
            if (map[nums[r]] == 0) {
                distinct++;
            }
            map[nums[r]]++;
            while (distinct > k) {
                map[nums[l]]--;
                if (map[nums[l]] == 0) {
                    distinct--;
                }
                l++;
            }
            while (distinct == k && map[nums[l]] > 1) {
                map[nums[l]]--;
                l++;
            }
            if (distinct == k) {
                res += l + 1;
            }
        }
        return res;
    }
}
